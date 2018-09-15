package ahoecherl.crif;

import com.acadiasoft.simm.model.object.*;
import com.acadiasoft.simm.model.object.imtree.identifiers.ProductClass;
import org.apache.commons.csv.CSVRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Crif {
    private List<Sensitivity> sensitivities = new LinkedList<>();
    private Map<String, AddOnNotionalFactor> addOnNotionalFactors = new HashMap<>();
    private Map<String, List<AddOnNotional>> addOnNotionals = new HashMap<>();
    private Map<ProductClass, ProductMultiplier> productMultipliers = new HashMap<>();
    private AddOnFixedAmount addOnFixedAmount;
    private List<ScheduleNotional> scheduleNotionals = new LinkedList<>();
    private List<SchedulePV> schedulePVs = new LinkedList<>();

    /*Constructor for a CRIF of one Counterparty/direction/regime which is required to have at least the following cols:
        ValuationDate,
        IMModel,
        productClass,
        riskType,
        qualifier,
        bucket,
        label1,
        label2,
        amount,
        amountCurrency,
        amountUSD,
        EndDate
    */
    public Crif(Iterable<CSVRecord> records) {
        for (CSVRecord record : records) {
            //Schedule PV
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd"));
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(("yyyy-MM-dd hh:mm:ss"));
            if (record.get("IMModel").equals("Schedule") && record.get("riskType").equals("PV")) {
                LocalDate valuationDate = LocalDate.parse(record.get("ValuationDate"), formatter);
                LocalDate endDate = LocalDate.parse(record.get("EndDate"), formatter2);
                BigDecimal PVUSD = new BigDecimal(record.get("amountUSD"));
                BigDecimal PV = new BigDecimal(record.get("amount"));
                String currency = record.get("amountCurrency");
                this.schedulePVs.add(new SchedulePV(PV, currency, PVUSD, valuationDate, endDate));
            } else if (record.get("IMModel").equals("Schedule") && record.get("riskType").equals("Notional")) {
                LocalDate valuationDate = LocalDate.parse(record.get("ValuationDate"), formatter);
                LocalDate endDate = LocalDate.parse(record.get("EndDate"), formatter2);
                BigDecimal NotionalUSD = new BigDecimal(record.get("amountUSD"));
                BigDecimal Notional = new BigDecimal(record.get("amount"));
                String currency = record.get("amountCurrency");
                this.scheduleNotionals.add(new ScheduleNotional(Notional, currency, NotionalUSD, valuationDate, endDate));
            } else if (record.get("riskType").equals("Param_ProductClassMultiplier")){
                BigDecimal multiplier = new BigDecimal(record.get("amount"));
                String productClass = record.get("qualifier");
                ProductMultiplier pm = new ProductMultiplier(productClass,multiplier);
                this.productMultipliers.put(pm.getProductClass(), pm);
                //this.productMultipliers.add(new ProductMultiplier(productClass, multiplier));
            } else if (record.get("riskType").equals("Param_AddOn-NotionalFactor")) {
                String product = record.get("qualifier");
                BigDecimal factor = new BigDecimal(record.get("amount"));
                addOnNotionalFactors.put(product, new AddOnNotionalFactor(product, factor));
            } else if (record.get("riskType").equals("Param_AddOn-FixedAmount")){
                BigDecimal amount = new BigDecimal(record.get("amount"));
                BigDecimal amountUSD = new BigDecimal(record.get("amountUSD"));
                String currency = record.get("amountCurrency");
                this.addOnFixedAmount = new AddOnFixedAmount(amount, currency, amountUSD);
            } else if (record.get("IMModel").equals("SIMM") && record.get("riskType").equals("Notional")){
                String product = record.get("qualifier");
                BigDecimal notional = new BigDecimal(record.get("amount"));
                BigDecimal notionalUSD = new BigDecimal(record.get("amountUSD"));
                String currency = record.get("amountCurrency");
                this.addOnNotionals.put(product, Arrays.asList(new AddOnNotional(product, notional, currency, notionalUSD)));
                //this.addOnNotionals.add(new AddOnNotional(product, notional, currency, notionalUSD));
            } else {
                String productClass = record.get("productClass");
                String riskType = record.get("riskType");
                String qualifier = record.get("qualifier");
                String bucket = record.get("bucket");
                String label1 = record.get("label1");
                String label2 = record.get("label2");
                BigDecimal amount = new BigDecimal(record.get("amount"));
                BigDecimal amountUSD = new BigDecimal(record.get("amountUSD"));
                String amountCurrency = record.get("amountCurrency");
                this.sensitivities.add(new Sensitivity(productClass, riskType, qualifier, bucket, label1, label2, amount, amountCurrency, amountUSD));
            }
        }
    }

    public List<Sensitivity> getSensitivities() {
        return sensitivities;
    }

    public Map<String, AddOnNotionalFactor> getAddOnNotionalFactors() {
        return addOnNotionalFactors;
    }

    public Map<String, List<AddOnNotional>> getAddOnNotionals() {
        return addOnNotionals;
    }

    public Map<ProductClass, ProductMultiplier> getProductMultipliers() {
        return productMultipliers;
    }

    public AddOnFixedAmount getAddOnFixedAmount() {
        return addOnFixedAmount;
    }

    public List<ScheduleNotional> getScheduleNotionals() {
        return scheduleNotionals;
    }

    public List<SchedulePV> getSchedulePVs() {
        return schedulePVs;
    }
}

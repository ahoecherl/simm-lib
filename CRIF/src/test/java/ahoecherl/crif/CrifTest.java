package ahoecherl.crif;

import com.acadiasoft.simm.engine.Simm;
import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.object.imtree.ImTree;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class CrifTest {

    @Test
    public void createCrif() throws Exception{
        System.out.println(new File("ResultCRIF.csv").getAbsolutePath());
        File f = new File("ResultCRIF.csv");
        Reader in = new FileReader(f);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);
        Crif crif = new Crif(records);
        int asdf = 1;
    }

    @Test
    public void calculateCrif() throws Exception{
        Reader in = new FileReader(new File("SingleCRIF.csv"));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);
        Crif crif = new Crif(records);
        List<Sensitivity> s = crif.getSensitivities();
        ImTree result = Simm.calculateTreeStandard(crif.getSensitivities());
        ImTree result2 = Simm.calculateTreeTotal(crif.getSensitivities(), crif.getProductMultipliers(), crif.getAddOnNotionalFactors(), crif.getAddOnNotionals(), crif.getAddOnFixedAmount());
        int asdf = 1;
    }

}

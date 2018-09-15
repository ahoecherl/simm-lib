package com.acadiasoft.simm.model.object;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SchedulePV implements Serializable {

    private final BigDecimal PV;
    private final String currency;
    private final BigDecimal PVUSD;
    private final LocalDate valuationDate;
    private final LocalDate endDate;

    public SchedulePV(BigDecimal PV, String currency, BigDecimal PVUSD, LocalDate valuationDate, LocalDate endDate) {
        this.PV = PV;
        this.currency = currency;
        this.PVUSD = PVUSD;
        this.valuationDate = valuationDate;
        this.endDate = endDate;
    }

    public String getCurrency() { return currency; }

    public BigDecimal getPV() { return PV; }

    public BigDecimal getPVUSD() { return PVUSD; }

    public LocalDate getValuationDate() { return valuationDate; }

    public LocalDate getEndDate() { return endDate; }

}

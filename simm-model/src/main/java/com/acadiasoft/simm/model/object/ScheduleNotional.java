package com.acadiasoft.simm.model.object;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduleNotional implements Serializable {

    private final BigDecimal notional;
    private final String currency;
    private final BigDecimal notionalUSD;
    private final LocalDate valuationDate;
    private final LocalDate endDate;

    public ScheduleNotional(BigDecimal notional, String currency, BigDecimal notionalUSD, LocalDate valuationDate, LocalDate endDate) {
        this.notional = notional;
        this.currency = currency;
        this.notionalUSD = notionalUSD;
        this.valuationDate = valuationDate;
        this.endDate = endDate;
    }

    public String getCurrency() { return currency; }

    public BigDecimal getNotional() { return notional; }

    public BigDecimal getNotionalUSD() { return notionalUSD; }

    public LocalDate getValuationDate() { return valuationDate; }

    public LocalDate getEndDate() { return endDate; }

}

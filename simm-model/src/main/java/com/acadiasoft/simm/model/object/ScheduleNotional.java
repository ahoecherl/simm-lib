package com.acadiasoft.simm.model.object;

import java.io.Serializable;
import java.math.BigDecimal;

public class ScheduleNotional implements Serializable {

    private final BigDecimal notional;
    private final String currency;
    private final BigDecimal notionalUSD;

    public ScheduleNotional(BigDecimal notional, String currency, BigDecimal notionalUSD) {
        this.notional = notional;
        this.currency = currency;
        this.notionalUSD = notionalUSD;
    }

    public String getCurrency() { return currency; }

    public BigDecimal getNotional() { return notional; }

    public BigDecimal getNotionalUSD() { return notionalUSD; }

}

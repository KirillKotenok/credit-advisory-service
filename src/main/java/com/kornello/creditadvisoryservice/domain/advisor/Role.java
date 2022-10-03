package com.kornello.creditadvisoryservice.domain.advisor;

import java.math.BigDecimal;

public enum Role {
    ASSOCIATE(BigDecimal.ONE, BigDecimal.valueOf(10000L)),
    PARTNER(BigDecimal.valueOf(10000L), BigDecimal.valueOf(50000L)),
    SENIOR(BigDecimal.valueOf(50000L), BigDecimal.valueOf(1000000L));

    private final BigDecimal minAmount;
    private final BigDecimal maxAmount;

    Role(BigDecimal minAmount, BigDecimal maxAmount) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }
}

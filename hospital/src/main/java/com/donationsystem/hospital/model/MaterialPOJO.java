package com.donationsystem.hospital.model;

import java.math.BigInteger;

public class MaterialPOJO {

    public MaterialPOJO() {}

    public MaterialPOJO(BigInteger variety, BigInteger amount) {
        this.variety = variety;
        this.amount = amount;
    }

    private BigInteger variety;
    private BigInteger amount;

    /**
     * @return the variety
     */
    public BigInteger getVariety() {
        return variety;
    }

    /**
     * @param variety the variety to set
     */
    public void setVariety(BigInteger variety) {
        this.variety = variety;
    }

    /**
     * @return the amount
     */
    public BigInteger getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }
}
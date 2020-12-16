package com.donationsystem.foundation.model;

import java.math.BigInteger;
import java.util.List;

public class RequestPOJO {
    private BigInteger num;
    private List<BigInteger> varieties;
    private List<BigInteger> amounts;
    private String reciver;

    /**
     * @return the varieties
     */
    public List<BigInteger> getVarieties() {
        return varieties;
    }

    /**
     * @param varieties the varieties to set
     */
    public void setVarieties(List<BigInteger> varieties) {
        this.varieties = varieties;
    }

    /**
     * @return the amounts
     */
    public List<BigInteger> getAmounts() {
        return amounts;
    }

    /**
     * @param amounts the amounts to set
     */
    public void setAmounts(List<BigInteger> amounts) {
        this.amounts = amounts;
    }

    /**
     * @return the reciver
     */
    public String getReciver() {
        return reciver;
    }

    /**
     * @param reciver the reciver to set
     */
    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    /**
     * @return the num
     */
    public BigInteger getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(BigInteger num) {
        this.num = num;
    }

}

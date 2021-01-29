package com.donationsystem.platform.model;

import java.math.BigInteger;

public class TimelineNode {
    private String reciver;
    private String holder;
    private String time;
    private BigInteger blockNumber;

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
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
     * @return the holder
     */
    public String getHolder() {
        return holder;
    }

    /**
     * @param holder the holder to set
     */
    public void setHolder(String holder) {
        this.holder = holder;
    }

    /**
     * @return the blockNumber
     */
    public BigInteger getBlockNumber() {
        return blockNumber;
    }

    /**
     * @param blockNumber the blockNumber to set
     */
    public void setBlockNumber(BigInteger blockNumber) {
        this.blockNumber = blockNumber;
    }

    /**
     * @param time
     * @param reciver
     * @param holder
     * @param blockNumber
     */
    public TimelineNode(String holder, String reciver, String time, BigInteger blockNumber) {
        this.time = time;
        this.reciver = reciver;
        this.holder = holder;
        this.blockNumber = blockNumber;
    }

    /**
     * 
     */
    public TimelineNode() {
    }
}

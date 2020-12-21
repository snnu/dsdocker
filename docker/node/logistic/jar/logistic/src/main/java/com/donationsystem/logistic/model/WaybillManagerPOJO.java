package com.donationsystem.logistic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "waybill_manager")
public class WaybillManagerPOJO {
    @Id
    @Column(name = "manager_address", nullable = false)
    private String managerAddress;

    /**
     * @return the managerAddress
     */
    public String getManagerAddress() {
        return managerAddress;
    }

    /**
     * @param managerAddress the managerAddress to set
     */
    public void setManagerAddress(String managerAddress) {
        this.managerAddress = managerAddress;
    }
}

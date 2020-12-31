package com.donationsystem.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {
    public Manager() {}

    public Manager(String managerAddress, String managerName) {
        this.managerAddress = managerAddress;
        this.managerName = managerName;
    }

    @Id
    @Column(name = "manager_address")
    private String managerAddress;

    @Column(name = "manager_name")
    private String managerName;

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

    /**
     * @return the managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param managerName the managerName to set
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}

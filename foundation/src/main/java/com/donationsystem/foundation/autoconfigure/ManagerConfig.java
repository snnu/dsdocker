package com.donationsystem.foundation.autoconfigure;

import com.donationsystem.foundation.contract.FoundationMaterialManager;
import com.donationsystem.foundation.contract.LocationManager;
import com.donationsystem.foundation.contract.RequestManager;
import com.donationsystem.foundation.model.Manager;
import com.donationsystem.foundation.constants.GasConstants;
import com.donationsystem.foundation.repository.ManagerRepo;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "manager")
public class ManagerConfig {

    private static final Logger logger = LoggerFactory.getLogger(ManagerConfig.class);

    private String locationManagerAddress;

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Bean
    public LocationManager locationManager() {
        Manager locationManagerEntity = managerRepo.findByManagerName("locationManager");
        String managerAddress;
        if(locationManagerEntity == null) {
            managerAddress = locationManagerAddress;
            Manager manager = new Manager(managerAddress, "locationManager");
            logger.debug("manager address: " + manager.getManagerAddress());
            managerRepo.save(manager);
        } else {
            managerAddress = locationManagerEntity.getManagerAddress();
        }
        LocationManager locationManager = LocationManager.load(managerAddress, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        return locationManager;
    }

    @Bean
    public FoundationMaterialManager foundationMaterialManager() throws Exception {
        Manager manager = managerRepo.findByManagerName("foundationMaterialManager");
        FoundationMaterialManager foundationMaterialManager;
        if(manager != null) {
            foundationMaterialManager = FoundationMaterialManager.load(manager.getManagerAddress(), web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        } else {
            foundationMaterialManager = FoundationMaterialManager.deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), "foundationMaterialManager").send();
            if(foundationMaterialManager != null) {
                managerRepo.save(new Manager(foundationMaterialManager.getContractAddress(), "foundationMaterialManager"));
            }
        }
        return foundationMaterialManager;
    }

    @Bean
    public RequestManager requestManager() throws Exception {
        Manager manager = managerRepo.findByManagerName("requestManager");
        RequestManager requestManager;
        if(manager != null) {
            requestManager = RequestManager.load(manager.getManagerAddress(), web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        } else {
            requestManager = RequestManager.deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), foundationMaterialManager().getContractAddress(), "requestManager").send();
            if(requestManager != null) {
                managerRepo.save(new Manager(requestManager.getContractAddress(), "requestManager"));
            }
        }
        return requestManager;
    }

    /**
     * @return the locationManagerAddress
     */
    public String getLocationManagerAddress() {
        return locationManagerAddress;
    }

    /**
     * @param locationManagerAddress the locationManagerAddress to set
     */
    public void setLocationManagerAddress(String locationManagerAddress) {
        this.locationManagerAddress = locationManagerAddress;
    }
}

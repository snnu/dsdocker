package com.donationsystem.logistic.autoconfigure;

import com.donationsystem.logistic.constants.GasConstants;
import com.donationsystem.logistic.contract.LocationManager;
import com.donationsystem.logistic.contract.WaybillManager;
import com.donationsystem.logistic.model.Manager;
import com.donationsystem.logistic.repository.ManagerRepo;

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
    public WaybillManager waybillManager() throws Exception {
        Manager manager = managerRepo.findByManagerName("waybillManager");
        if (manager == null) {
            WaybillManager waybillManager = WaybillManager
                    .deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), "waybillManager")
                    .send();
            if (waybillManager != null) {
                managerRepo.save(new Manager(waybillManager.getContractAddress(), "waybillManager"));
            }
            return waybillManager;
        } else {
            WaybillManager waybillManager = WaybillManager.load(manager.getManagerAddress(), web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            return waybillManager;
        }
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

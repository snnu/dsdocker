package com.donationsystem.hospital.autoconfigure;

import com.donationsystem.hospital.constants.GasConstants;
import com.donationsystem.hospital.contract.HospitalMaterialManager;
import com.donationsystem.hospital.contract.LocationManager;
import com.donationsystem.hospital.contract.RequestManager;
import com.donationsystem.hospital.model.Manager;
import com.donationsystem.hospital.repository.ManagerRepo;

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
        Manager manager = managerRepo.findByManagerName("locationManager");
        String managerAddress;
        if(manager == null) {
            managerAddress = locationManagerAddress;
            manager = new Manager(managerAddress, "locationManager");
            managerRepo.save(manager);
        } else {
            managerAddress = manager.getManagerAddress();
        }
        LocationManager locationManager = LocationManager.load(managerAddress, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        return locationManager;
    }

    @Bean
    public HospitalMaterialManager hospitalMaterialManager() throws Exception {
        Manager manager = managerRepo.findByManagerName("hospitalMaterialManager");
        HospitalMaterialManager hospitalMaterialManager;
        if(manager == null) {
            hospitalMaterialManager = HospitalMaterialManager.deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), "hospitalMaterialManager").send();
            if(hospitalMaterialManager != null) {
                managerRepo.save(new Manager(hospitalMaterialManager.getContractAddress(), "hospitalMaterialManager"));
            }
            
        } else {
            hospitalMaterialManager = HospitalMaterialManager.load(manager.getManagerAddress(), web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        }
        return hospitalMaterialManager;
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

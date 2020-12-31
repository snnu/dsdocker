package com.donationsystem.platform.autoconfigure;

import com.donationsystem.platform.constants.GasConstants;
import com.donationsystem.platform.contract.LocationManager;
import com.donationsystem.platform.model.Manager;
import com.donationsystem.platform.repo.ManagerRepo;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagerConfig {

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Bean
    public LocationManager locationManager() throws Exception {
        Manager manager = managerRepo.findByManagerName("locationManager");
        LocationManager locationManager;
        if (manager == null) {
            locationManager = LocationManager
                    .deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                    .send();
            managerRepo.save(new Manager(locationManager.getContractAddress(), "locationManager"));
        } else {
            locationManager = LocationManager.load(manager.getManagerAddress(), web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        }
        return locationManager;
    }
}

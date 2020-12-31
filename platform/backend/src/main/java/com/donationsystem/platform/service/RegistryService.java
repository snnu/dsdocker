package com.donationsystem.platform.service;

import com.donationsystem.platform.contract.LocationManager;

import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryService {

    private static final Logger logger = LoggerFactory.getLogger(RegistryService.class); 

    @Autowired
    private LocationManager locationManager;

    public Boolean allowRegistryAddress(String address) throws Exception {
        TransactionReceipt receipt = locationManager.allow(address).send();
        if(receipt.isStatusOK()) {
            return true;
        }
        logger.error(receipt.getMessage() + " " + receipt.getStatus());
        return false;
    }

    public Boolean disallowRegistryAddress(String address) throws Exception {
        TransactionReceipt receipt = locationManager.disallow(address).send();
        if(receipt.isStatusOK()) {
            return true;
        }
        logger.error(receipt.getMessage() + " " + receipt.getStatus());
        return false;
    }

    public String getLocationManagerAddress() {
        return locationManager.getContractAddress();
    }
}

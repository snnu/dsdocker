package com.donationsystem.foundation.service;

import javax.annotation.PostConstruct;

import com.donationsystem.foundation.contract.FoundationMaterialManager;
import com.donationsystem.foundation.contract.LocationManager;
import com.donationsystem.foundation.contract.RequestManager;
import com.donationsystem.foundation.util.RegistryTemplate;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private Credentials credentials;

    @Autowired
    private LocationManager locationManager;

    @Autowired
    private FoundationMaterialManager foundationMaterialManager;

    @Autowired
    private RequestManager requestManager;

    @Autowired
    private RegistryTemplate registryTemplate;


    @PostConstruct
    public void init() throws Exception {
        registryNodeAccount();
        registryFoundationMaterialManager();
        registryRequestManager();
    }

    public Boolean registryNodeAccount() throws Exception {
        Boolean res = locationManager.showAllowed(credentials.getAddress()).send();
        if (!res) {
            res = registryTemplate.locationManagerAllowRegistry(credentials.getAddress(), "172.100.0.9");
            if (!res) {
                return false;
            }
        }
        if (!locationManager.getAddress("foundation").send().equals(credentials.getAddress())) {
            TransactionReceipt receipt = locationManager.setAddress(credentials.getAddress(), "foundation")
                    .send();
            if (receipt.isStatusOK()) {
                return true;
            }
            logger.error(receipt.getMessage() + " " + receipt.getStatus());
            return false;
        }
        return true;
    }

    public Boolean registryFoundationMaterialManager() throws Exception {
        Boolean res = locationManager.showAllowed(foundationMaterialManager.getContractAddress()).send();
        if(!res) {
            res = registryTemplate.locationManagerAllowRegistry(foundationMaterialManager.getContractAddress(), "172.100.0.9");
            if(!res) {
                return false;
            }
        }
        if(!locationManager.getAddress("foundationMaterialManager").send().equals(foundationMaterialManager.getContractAddress())) {
            TransactionReceipt receipt = foundationMaterialManager.registry(locationManager.getContractAddress()).send();
            if(receipt.isStatusOK()) {
                return true;
            }
            return false;
        }
        return true;
    }

    public Boolean registryRequestManager() throws Exception {
        Boolean res = locationManager.showAllowed(requestManager.getContractAddress()).send();
        if(!res) {
            res = registryTemplate.locationManagerAllowRegistry(requestManager.getContractAddress(), "172.100.0.9");
            if(!res) {
                return false;
            }
        }
        if(!locationManager.getAddress("requestManager").send().equals(requestManager.getContractAddress())) {
            TransactionReceipt receipt = requestManager.registry(locationManager.getContractAddress()).send();
            if(receipt.isStatusOK()) {
                return true;
            }
            return false;
        }
        return true;
    }
    
    public Boolean allowHospital(String address) throws Exception {
        TransactionReceipt receipt = requestManager.allow(address).send();
        if(receipt.isStatusOK()) {
            return true;
        }
        return false;
    }

    public Boolean disallowHospital(String address) throws Exception {
        TransactionReceipt receipt = requestManager.disallow(address).send();
        if(receipt.isStatusOK()) {
            return true;
        }
        return false;
    }
}

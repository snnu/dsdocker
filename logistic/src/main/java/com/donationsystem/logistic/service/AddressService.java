package com.donationsystem.logistic.service;

import javax.annotation.PostConstruct;

import com.donationsystem.logistic.contract.LocationManager;
import com.donationsystem.logistic.contract.WaybillManager;
import com.donationsystem.logistic.util.RegistryTemplate;

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
    private WaybillManager waybillManager;

    @Autowired
    private RegistryTemplate registryTemplate;

    @PostConstruct
    public void init() throws Exception {
        registryNodeAccount();
        registryWaybillManager();
    }

    public Boolean registryNodeAccount() throws Exception {
        logger.debug("nodeaccount:" + credentials.getAddress());
        Boolean res = locationManager.showAllowed(credentials.getAddress()).send();
        logger.debug("registryNodeAccount res:" + res);
        if (!res) {
            res = registryTemplate.allowRegistryWaybillManager(credentials.getAddress(), "172.100.0.9");
            if (!res) {
                return false;
            }
        }
        if (!locationManager.getAddress("logistic").send().equals(credentials.getAddress())) {
            TransactionReceipt receipt = locationManager.setAddress(credentials.getAddress(), "logistic").send();
            if (receipt.isStatusOK()) {
                return true;
            }
            logger.error(receipt.getMessage() + " " + receipt.getStatus());
            return false;
        }
        return true;
    }

    public Boolean registryWaybillManager() throws Exception {
        Boolean res = locationManager.showAllowed(waybillManager.getContractAddress()).send();
        if (!res) {
            res = registryTemplate.allowRegistryWaybillManager(waybillManager.getContractAddress(), "172.100.0.9");
            if (!res) {
                return false;
            }
        }
        if (!locationManager.getAddress("waybillManager").send().equals(waybillManager.getContractAddress())) {
            TransactionReceipt receipt = waybillManager.registry(locationManager.getContractAddress()).send();
            if (receipt.isStatusOK()) {
                return true;
            }
            logger.error(receipt.getMessage() + " " + receipt.getStatus());
            return false;
        }
        return true;
    }
}

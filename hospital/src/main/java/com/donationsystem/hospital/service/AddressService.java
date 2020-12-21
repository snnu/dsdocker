package com.donationsystem.hospital.service;

import javax.annotation.PostConstruct;

import com.donationsystem.hospital.contract.HospitalMaterialManager;
import com.donationsystem.hospital.contract.LocationManager;
import com.donationsystem.hospital.util.RegistryTemplate;

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
    private HospitalMaterialManager hospitalMaterialManager;

    @Autowired
    private RegistryTemplate registryTemplate;


    @PostConstruct
    public void init() throws Exception {
        registryNodeAccount();
        registryHospitalMaterialManager();
    }

    public Boolean registryNodeAccount() throws Exception {
        Boolean res = locationManager.showAllowed(credentials.getAddress()).send();
        if (!res) {
            res = registryTemplate.locationManagerAllowRegistry(credentials.getAddress(), "172.100.0.9");
            if (!res) {
                return false;
            }
        }
        if (!locationManager.getAddress("hospital").send().equals(credentials.getAddress())) {
            TransactionReceipt receipt = locationManager.setAddress(credentials.getAddress(), "hospital")
                    .send();
            if (receipt.isStatusOK()) {
                return true;
            }
            logger.error(receipt.getMessage());
            return false;
        }
        return true;
    }

    public Boolean registryHospitalMaterialManager() throws Exception {
        Boolean res = locationManager.showAllowed(hospitalMaterialManager.getContractAddress()).send();
        if(!res) {
            res = registryTemplate.locationManagerAllowRegistry(hospitalMaterialManager.getContractAddress(), "172.100.0.9");
            if(!res) {
                return false;
            }
        }
        if(!locationManager.getAddress("hospitalMaterialManager").send().equals(hospitalMaterialManager.getContractAddress())) {
            TransactionReceipt receipt = hospitalMaterialManager.registry(locationManager.getContractAddress()).send();
            if(receipt.isStatusOK()) {
                return true;
            }
            return false;
        }
        return true;
    }
}

package com.donationsystem.platform.service;

import com.donationsystem.platform.constants.GasConstants;
import com.donationsystem.platform.contract.FoundationMaterialManager;
import com.donationsystem.platform.contract.HospitalMaterialManager;
import com.donationsystem.platform.contract.LocationManager;
import com.donationsystem.platform.contract.WaybillManager;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private LocationManager locationManager;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    public WaybillManager getWaybillManager(String waybillManagerName) throws Exception {
        String contractAddress = locationManager.getAddress(waybillManagerName).send();
        return WaybillManager.load(contractAddress, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }

    public FoundationMaterialManager getFoundationMaterialManager(String foundationMaterialManagerName)
            throws Exception {
        String contractAddress = locationManager.getAddress(foundationMaterialManagerName).send();
        return FoundationMaterialManager.load(contractAddress, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }

    public HospitalMaterialManager getHospitalMaterialManager(String hospitalMaterialManagerName) throws Exception {
        String contractAddress = locationManager.getAddress(hospitalMaterialManagerName).send();
        return HospitalMaterialManager.load(contractAddress, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }
}

package com.donationsystem.hospital.service;

import com.donationsystem.hospital.constants.GasConstants;
import com.donationsystem.hospital.contract.LocationManager;
import com.donationsystem.hospital.contract.RequestManager;
import com.donationsystem.hospital.contract.WaybillManager;

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

    public RequestManager getRequestManager(String name) throws Exception {
        String address = locationManager.getAddress(name).send();
        RequestManager requestManager = RequestManager.load(address, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        return requestManager;
    }

    public WaybillManager getWaybillManager(String name) throws Exception {
        String address = locationManager.getAddress(name).send();
        WaybillManager waybillManager = WaybillManager.load(address, web3j, credentials,  new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        return waybillManager;
    }
}

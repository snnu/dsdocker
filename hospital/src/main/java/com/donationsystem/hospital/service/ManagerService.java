package com.donationsystem.hospital.service;

import java.util.HashMap;
import java.util.Map;

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

    private Map<String, RequestManager> requestManagerMap;

    private Map<String, WaybillManager> waybillManagerMap;

    public ManagerService() {
        requestManagerMap = new HashMap<>();
        waybillManagerMap = new HashMap<>();
    }

    public RequestManager getRequestManager(String requestManagerName) throws Exception {
        if(requestManagerMap.containsKey(requestManagerName)) {
            return requestManagerMap.get(requestManagerName);
        }
        String address = locationManager.getAddress(requestManagerName).send();
        RequestManager requestManager = RequestManager.load(address, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        requestManagerMap.put(requestManagerName, requestManager);
        return requestManager;
    }

    public WaybillManager getWaybillManager(String waybillManagerName) throws Exception {
        if(waybillManagerMap.containsKey(waybillManagerName)) {
            return waybillManagerMap.get(waybillManagerName);
        }
        String address = locationManager.getAddress(waybillManagerName).send();
        WaybillManager waybillManager = WaybillManager.load(address, web3j, credentials,  new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        waybillManagerMap.put(waybillManagerName, waybillManager);
        return waybillManager;
    }
}

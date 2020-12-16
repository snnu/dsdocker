package com.donationsystem.foundation.service;

import com.donationsystem.foundation.constants.GasConstants;
import com.donationsystem.foundation.contract.LocationManager;
import com.donationsystem.foundation.contract.WaybillManager;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);
    
    @Autowired
    private LocationManager locationManager;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    public WaybillManager getWaybillManager(String name) throws Exception {
        String address = locationManager.getAddress(name).send();
        logger.debug("getWaybillManager " + name + " :" + address);
        WaybillManager waybillManager = WaybillManager.load(address, web3j, credentials,  new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        return waybillManager;
    }
}

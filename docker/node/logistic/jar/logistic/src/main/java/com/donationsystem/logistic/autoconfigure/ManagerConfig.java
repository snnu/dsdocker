package com.donationsystem.logistic.autoconfigure;

import java.util.List;

import com.donationsystem.logistic.constants.GasConstants;
import com.donationsystem.logistic.contract.WaybillManager;
import com.donationsystem.logistic.model.WaybillManagerPOJO;
import com.donationsystem.logistic.repository.ManagerRepo;
import com.google.common.collect.Lists;

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
    public WaybillManager getWaybillManager() throws Exception {
        List<WaybillManagerPOJO> res = Lists.newArrayList(managerRepo.findAll());
        if (res.size() == 0) {
            WaybillManager waybillManager = WaybillManager
                    .deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                    .send();
            if (waybillManager != null) {
                WaybillManagerPOJO waybillManagerPOJO = new WaybillManagerPOJO();
                waybillManagerPOJO.setManagerAddress(waybillManager.getContractAddress());
                managerRepo.save(waybillManagerPOJO);
            }
            return waybillManager;
        } else {
            WaybillManager waybillManager = WaybillManager.load(res.get(0).getManagerAddress(), web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            return waybillManager;
        }
    }
}

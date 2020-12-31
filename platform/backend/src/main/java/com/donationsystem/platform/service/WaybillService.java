package com.donationsystem.platform.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.donationsystem.platform.constants.GasConstants;
import com.donationsystem.platform.contract.LocationManager;
import com.donationsystem.platform.contract.Material;
import com.donationsystem.platform.contract.Waybill;
import com.donationsystem.platform.contract.WaybillManager;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillService {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Autowired
    private LocationManager locationManager;

    public Map<BigInteger, List<String[]>> getStatusByNumber(String waybillNumber, String waybillManagerName) throws Exception {
        Map<BigInteger, List<String[]>> res = new HashMap<>();
        WaybillManager waybillManager = managerService.getWaybillManager(waybillManagerName);
        String waybillAddress = waybillManager.getWallbillAddress(waybillNumber).send();
        Waybill waybill = Waybill.load(waybillAddress, web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        List<String> materialAddresses = waybill.getMaterialArr().send();
        for (String s : materialAddresses) {
            Material m = Material.load(s, web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            BigInteger variety = m.getVariety().send();
            if(!res.containsKey(variety)) {
                res.put(variety, new ArrayList<>());
            }
            res.get(variety).add(new String[]{locationManager.getName(m.getCurHolder().send()).send(), m.getUsed().send().toString()});
        }
        return res;
    }
}

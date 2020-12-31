package com.donationsystem.platform.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.donationsystem.platform.contract.FoundationMaterialManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoundationService {

    @Autowired
    private ManagerService managerService;

    public Map<BigInteger, BigInteger> getFoundationMaterialAmounts(List<BigInteger> varieties,  String foundationMaterialManagerName)
            throws Exception {
        Map<BigInteger, BigInteger> res = new HashMap<>();
        FoundationMaterialManager foundationMaterialManager = managerService.getFoundationMaterialManager(foundationMaterialManagerName);
        for(BigInteger variety : varieties) {
            res.put(variety, foundationMaterialManager.getVarietyAmount(variety).send());
        }
        return res;
    }

}

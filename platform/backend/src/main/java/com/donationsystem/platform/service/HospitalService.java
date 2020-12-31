package com.donationsystem.platform.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.donationsystem.platform.contract.HospitalMaterialManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    
    @Autowired
    private ManagerService managerService;
    
    public Map<BigInteger, BigInteger> getHospitalMaterialAmounts(List<BigInteger> varieties,  String hospitalMaterialManagerName)
            throws Exception {
        Map<BigInteger, BigInteger> res = new HashMap<>();
        HospitalMaterialManager hospitalMaterialManager = managerService.getHospitalMaterialManager(hospitalMaterialManagerName);
        for(BigInteger variety : varieties) {
            res.put(variety, hospitalMaterialManager.getVarietyAmount(variety).send());
        }
        return res;
    }

}

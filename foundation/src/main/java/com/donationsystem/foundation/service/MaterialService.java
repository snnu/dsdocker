package com.donationsystem.foundation.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.donationsystem.foundation.contract.FoundationMaterialManager;
import com.donationsystem.foundation.contract.RequestManager;
import com.donationsystem.foundation.model.MaterialPOJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
    
    @Autowired
    private FoundationMaterialManager foundationMaterialManager;

    @Autowired
    private RequestManager requestManager;

    public List<MaterialPOJO> getMaterialAmounts(List<BigInteger> varieties) throws Exception {
        List<MaterialPOJO> res = new ArrayList<>();
        for(BigInteger i : varieties) {
            res.add(new MaterialPOJO(i, foundationMaterialManager.getVarietyAmount(i).send().subtract(requestManager.getLockedMaterial(i).send())));
        }
        return res;
    }
}

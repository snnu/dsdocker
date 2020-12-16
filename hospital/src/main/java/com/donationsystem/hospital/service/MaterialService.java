package com.donationsystem.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.donationsystem.hospital.contract.HospitalMaterialManager;
import com.donationsystem.hospital.model.MaterialPOJO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;

@Service
public class MaterialService {

    private static final Logger logger = LoggerFactory.getLogger(MaterialService.class);

    @Autowired
    private HospitalMaterialManager hospitalMaterialManager;

    public Boolean useMaterial(BigInteger variety, BigInteger amount) throws Exception {
        TransactionReceipt receipt = hospitalMaterialManager.setUesd(variety, amount).send();
        if (receipt.isStatusOK()) {
            return true;
        }
        logger.error(receipt.getMessage());
        return false;
    }

    public List<MaterialPOJO> getMaterialAmounts(List<BigInteger> varieties) throws Exception {
        List<MaterialPOJO> res = new ArrayList<>();
        for(BigInteger i : varieties) {
            res.add(new MaterialPOJO(i, hospitalMaterialManager.getVarietyAmount(i).send()));
        }
        return res;
    }
}

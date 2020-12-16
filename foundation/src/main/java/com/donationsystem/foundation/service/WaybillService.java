package com.donationsystem.foundation.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.donationsystem.foundation.constants.GasConstants;
import com.donationsystem.foundation.contract.FoundationMaterialManager;
import com.donationsystem.foundation.contract.Waybill;
import com.donationsystem.foundation.contract.WaybillManager;
import com.donationsystem.foundation.util.FoundationRestTemplate;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillService {

    private static final Logger logger = LoggerFactory.getLogger(WaybillService.class);

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Autowired
    private FoundationMaterialManager foundationMaterialManager;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private FoundationRestTemplate foundationRestTemplate;

    public Boolean reciveWayBill(String number, String name) throws Exception {
        logger.debug("number: " + number);
        WaybillManager waybillManager = managerService.getWaybillManager(name);
        String address = waybillManager.getWallbillAddress(number).send();
        if (address.equals("0x0000000000000000000000000000000000000000")) {
            logger.error("no such address");
            return false;
        }
        Waybill wayBill = Waybill.load(address, web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        if (!foundationRestTemplate.RequestOwnerChange(number)) {
            throw new Exception("RequestOwnerChange Error");
        }
        TransactionReceipt res = wayBill.setReciverConfirm().send();
        logger.debug("From: " + res.getFrom());
        logger.debug("To: " + res.getTo());
        if (res.isStatusOK()) {
            List<String> materials = wayBill.getMaterialArr().send();
            res = foundationMaterialManager.setMaterials(materials).send();
            return res.isStatusOK();
        } else {
            logger.error(res.getMessage());
            return false;
        }
    }

    public List<String> delivery(List<BigInteger> varieties, List<BigInteger> amounts, String waybill)
            throws Exception {
        List<String> res = new ArrayList<>();
        if (varieties.size() != amounts.size()) {
            return res;
        }
        for (int i = 0; i < varieties.size(); i++) {
            TransactionReceipt receip = foundationMaterialManager
                    .getMaterials(varieties.get(i), amounts.get(i), waybill).send();
            if (receip.isStatusOK()) {
                res.addAll(foundationMaterialManager.getGetMaterialsOutput(receip).getValue1());
            } else {
                throw new Exception(receip.getMessage());
            }
        }
        return res;
    }

    public String RequestCreateWaybill(List<BigInteger> varieties, List<BigInteger> amounts, String nodeName) {
        return foundationRestTemplate.RequestCreateWaybill(varieties, amounts, nodeName);
    }

}

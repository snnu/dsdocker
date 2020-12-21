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
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
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

    public Boolean reciveWayBill(String number, String waybillManagerName) throws Exception {
        logger.debug("number: " + number);
        WaybillManager waybillManager = managerService.getWaybillManager(waybillManagerName);
        String address = waybillManager.getWallbillAddress(number).send();
        if (address.equals("0x0000000000000000000000000000000000000000")) {
            logger.error("no such address");
            return false;
        }
        TransactionReceipt receipt = foundationMaterialManager.setMaterials(address).send();
        if(receipt.isStatusOK()) {
            return true;
        }
        for(Log log: receipt.getLogs()) {
            logger.error(log.getData());
        }
        logger.error(receipt.getStatus());
        logger.error(receipt.getMessage());
        return false;
    }

    public List<String> delivery(List<BigInteger> varieties, List<BigInteger> amounts, String waybillManagerName, String number)
            throws Exception {
        List<String> res = new ArrayList<>();
        if (varieties.size() != amounts.size()) {
            return res;
        }
        WaybillManager waybillManager = managerService.getWaybillManager(waybillManagerName);
        String address = waybillManager.getWallbillAddress(number).send();
        for (int i = 0; i < varieties.size(); i++) {
            TransactionReceipt receip = foundationMaterialManager
                    .getMaterials(varieties.get(i), amounts.get(i), address).send();
            if (receip.isStatusOK()) {
                res.addAll(foundationMaterialManager.getGetMaterialsOutput(receip).getValue1());
            } else {
                throw new Exception(receip.getMessage());
            }
        }
        return res;
    }

    public String RequestCreateWaybill(List<BigInteger> varieties, List<BigInteger> amounts, String hospitalMaterialManagerName, String logisticName) {
        // 该IP应该由查询得来，此处写死
        return foundationRestTemplate.RequestCreateWaybill(varieties, amounts, hospitalMaterialManagerName, "172.100.0.7");
    }
}

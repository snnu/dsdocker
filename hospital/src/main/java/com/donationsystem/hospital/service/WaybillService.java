package com.donationsystem.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.donationsystem.hospital.constants.GasConstants;
import com.donationsystem.hospital.contract.HospitalMaterialManager;
import com.donationsystem.hospital.contract.RequestManager;
import com.donationsystem.hospital.contract.Waybill;
import com.donationsystem.hospital.contract.WaybillManager;
import com.donationsystem.hospital.util.HospitalRestTemplate;

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
    private ManagerService managerService;

    @Autowired
    private HospitalMaterialManager hospitalMaterialManager;

    @Autowired
    private HospitalRestTemplate hospitalRestTemplate;

    public Boolean reciveMaterial(String number, String name) throws Exception {
        WaybillManager waybillManager = managerService.getWaybillManager(name);
        String address = waybillManager.getWallbillAddress(number).send();
        if (address.equals("0x0000000000000000000000000000000000000000")) {
            logger.error("no such address");
            return false;
        }
        Waybill wayBill = Waybill.load(address, web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        if(!hospitalRestTemplate.RequestOwnerChange(number)) {
            throw new Exception("RequestOwnerChange Error");
        }
        TransactionReceipt res = wayBill.setReciverConfirm().send();
        logger.debug("From: " + res.getFrom());
        logger.debug("To: " + res.getTo());
        if (res.isStatusOK()) {
            List<String> materials = wayBill.getMaterialArr().send();
            res = hospitalMaterialManager.setMaterials(materials).send();
            return res.isStatusOK();
        } else {
            logger.error(res.getMessage());
            return false;
        }
    }
}

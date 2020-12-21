package com.donationsystem.hospital.service;

import java.util.List;

import com.donationsystem.hospital.constants.GasConstants;
import com.donationsystem.hospital.contract.HospitalMaterialManager;
import com.donationsystem.hospital.contract.Waybill;
import com.donationsystem.hospital.contract.WaybillManager;

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


    public Boolean reciveMaterial(String number, String waybillManagerName) throws Exception {
        WaybillManager waybillManager = managerService.getWaybillManager(waybillManagerName);
        String address = waybillManager.getWallbillAddress(number).send();
        if (address.equals("0x0000000000000000000000000000000000000000")) {
            logger.error("no such address");
            return false;
        }
        TransactionReceipt receipt = hospitalMaterialManager.setMaterials(address).send();
        if(receipt.isStatusOK()) {
            return true;
        }
        return false;
    }
}

package com.donationsystem.logistic.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.donationsystem.logistic.constants.GasConstants;
import com.donationsystem.logistic.contract.Waybill;
import com.donationsystem.logistic.contract.WaybillManager;
import com.donationsystem.logistic.util.WaybillRestTemplate;

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
    private WaybillManager waybillManager;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Autowired
    private WaybillRestTemplate waybillRestTemplate;

    public String deployWayBillByMaterial(String _reciver, List<BigInteger> varieties,
            List<BigInteger> amounts) throws Exception {
        TransactionReceipt res;
        String number = simpleDateFormat.format(new Date());
        Waybill wayBill = Waybill.deploy(web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), _reciver, number).send();
        res = wayBill.setMaterial(varieties, amounts).send();
        if (res.isStatusOK()) {
            waybillManager.setWallbillAddress(number, wayBill.getContractAddress());
            res = waybillManager.setWallbillAddress(number, wayBill.getContractAddress()).send();
        }
        if (res.isStatusOK()) {
            return number;
        }
        throw new Exception("deploy error");
    }

    public String deployWayBillByAddress(String _reciver, List<BigInteger> varieties,
            List<BigInteger> amounts) throws Exception {
        TransactionReceipt res;
        String number = simpleDateFormat.format(new Date());
        Waybill wayBill = Waybill.deploy(web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), _reciver, number).send();
        waybillManager.setWallbillAddress(number, wayBill.getContractAddress());
        List<String> materialAdresses = waybillRestTemplate.requestMaterial(varieties, amounts, number);
        res = wayBill.setMaterialArr(materialAdresses).send();
        if (res.isStatusOK()) {
            res = waybillManager.setWallbillAddress(number, wayBill.getContractAddress()).send();
        }
        if (res.isStatusOK()) {
            return number;
        }
        throw new Exception("deploy error, try it later");
    }

    public String findWayBillAddress(String number) throws Exception {
        return waybillManager.getWallbillAddress(number).send();
    }

    public Boolean setOwnerToRequester(String number, String address) throws Exception {
        logger.debug("number: " + number);
        logger.debug("address: " + address);
        String waybillAddress = waybillManager.getWallbillAddress(number).send();
        Waybill wayBill = Waybill.load(waybillAddress, web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        TransactionReceipt receipt = wayBill.setMaterialsOwner(address).send();
        if (receipt.isStatusOK()) {
            return true;
        } else {
            logger.debug("receipt.getMessage(): " + receipt.getMessage());
            return false;
        }
    }
}

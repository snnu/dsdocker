package com.donationsystem.logistic.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.donationsystem.logistic.constants.GasConstants;
import com.donationsystem.logistic.contract.LocationManager;
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
    private LocationManager locationManager;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Autowired
    private WaybillRestTemplate waybillRestTemplate;

    public String deployWayBillByMaterial(String reciverName, List<BigInteger> varieties, List<BigInteger> amounts)
            throws Exception {
        TransactionReceipt res;
        String number = simpleDateFormat.format(new Date());
        String reciverAddress = locationManager.getAddress(reciverName).send();
        logger.debug("reciverAddress: " + reciverAddress);
        Waybill wayBill = Waybill.deploy(web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), reciverAddress, number).send();
        res = wayBill.setMaterial(varieties, amounts).send();
        if (res.isStatusOK()) {
            res = waybillManager.setWallbillAddress(number, wayBill.getContractAddress()).send();
        }
        if (res.isStatusOK()) {
            return number;
        }
        logger.error(res.getMessage());
        return "";
    }

    public String deployWayBillByAddress(String reciverAddress, List<BigInteger> varieties, List<BigInteger> amounts,
            String foundationName) throws Exception {
        TransactionReceipt receipt;
        String number = simpleDateFormat.format(new Date());
        Waybill wayBill = Waybill.deploy(web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), reciverAddress, number).send();
        receipt = waybillManager.setWallbillAddress(number, wayBill.getContractAddress()).send();
        if (receipt.isStatusOK()) {
            // 该IP应该是由节点名查询得来，此处写死
            List<String> materialAdresses = waybillRestTemplate.requestMaterial(varieties, amounts, number,
                    "172.100.0.6");
            receipt = wayBill.setMaterialArr(materialAdresses).send();
            if (receipt.isStatusOK()) {
                return number;
            }
            logger.error(receipt.getMessage() + " " + receipt.getStatus());
        }
        logger.error(receipt.getMessage() + " " + receipt.getStatus());
        return "";
    }

    public String findWayBillAddress(String number) throws Exception {
        return waybillManager.getWallbillAddress(number).send();
    }
}

package com.donationsystem.logistic.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.donationsystem.logistic.constants.GasConstants;
import com.donationsystem.logistic.contract.WayBill;
import com.donationsystem.logistic.model.WayBillPOJO;
import com.donationsystem.logistic.repository.WaybillRepo;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillService {

    @Autowired
    private WaybillRepo waybillRepo;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    public boolean deployWayBill(String _reciver, List<BigInteger> materialVarities, List<BigInteger> materialAmounts)
            throws Exception {
        boolean res;
        String number = simpleDateFormat.format(new Date());
        WayBill wayBill = WayBill
                .deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT),
                        _reciver, number)
                .send();
        res = wayBill.SetMaterialArr(materialVarities, materialAmounts).send().isStatusOK();
        if (res) {
            WayBillPOJO wayBillPOJO = new WayBillPOJO();
            wayBillPOJO.setAddress(wayBill.getContractAddress());
            wayBillPOJO.setNumber(number);
            waybillRepo.save(wayBillPOJO);
        }
        return res;
    }

    public boolean deployWayBill(String _reciver, List<String> materialAdresses) throws Exception {
        boolean res;
        String number = simpleDateFormat.format(new Date());
        WayBill wayBill = WayBill
                .deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT),
                        _reciver, number)
                .send();
        res = wayBill.SetMaterialArr(materialAdresses).send().isStatusOK();
        if (res) {
            WayBillPOJO wayBillPOJO = new WayBillPOJO();
            wayBillPOJO.setAddress(wayBill.getContractAddress());
            wayBillPOJO.setNumber(number);
            waybillRepo.save(wayBillPOJO);
        }
        return res;
    }
}

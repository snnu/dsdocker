package com.donationsystem.hospital.service;

import java.math.BigInteger;
import java.util.List;

import com.donationsystem.hospital.contract.RequestManager;

import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RquestService {

    private static final Logger logger = LoggerFactory.getLogger(RquestService.class);

    @Autowired
    private ManagerService managerService;

    public BigInteger requestMaterial(List<BigInteger> varieties, List<BigInteger> amounts, String name)
            throws Exception {
        RequestManager requestManager = managerService.getRequestManager(name);
        TransactionReceipt receipt = requestManager.CreateReq(varieties, amounts).send();
        if (receipt.isStatusOK()) {
            return requestManager.getCreateReqOutput(receipt).getValue1();
        }
        logger.error(receipt.getMessage());
        return new BigInteger("-1");
    }

    public BigInteger getRequestStatus(BigInteger num, String name) throws Exception {
        RequestManager requestManager = managerService.getRequestManager(name);
        return requestManager.getReqState(num).send();
    }

    public String getWaybillNum(BigInteger num, String name) throws Exception {
        RequestManager requestManager = managerService.getRequestManager(name);
        return requestManager.getWayBillNum(num).send();
    }
}

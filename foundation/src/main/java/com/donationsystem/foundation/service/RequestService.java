package com.donationsystem.foundation.service;

import java.math.BigInteger;
import java.util.List;

import com.donationsystem.foundation.contract.RequestManager;
import com.donationsystem.foundation.model.RequestPOJO;

import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestManager requestManager;

    public RequestPOJO getNextRequest() throws Exception {
        RequestPOJO requestPOJO = new RequestPOJO();
        Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String> res = requestManager.getReq().send();
        requestPOJO.setNum(res.getValue1());
        requestPOJO.setVarieties(res.getValue2());
        requestPOJO.setAmounts(res.getValue3());
        requestPOJO.setReciver(res.getValue4());
        return requestPOJO;
    }

    public Boolean setState(BigInteger state) throws Exception {
        TransactionReceipt receipt = requestManager.handleReq(state).send();
        if(receipt.isStatusOK()) {
            if(requestManager.getHandleReqOutput(receipt).getValue1()) {
                return true;
            } else {
                return false;
            }
        }
        logger.error(receipt.getMessage() + " " + receipt.getStatus());
        return false;
    }

    public RequestPOJO getNextAgreedRequest() throws Exception {
        RequestPOJO requestPOJO = new RequestPOJO();
        Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String> res = requestManager.getAgreedReq().send();
        requestPOJO.setNum(res.getValue1());
        requestPOJO.setVarieties(res.getValue2());
        requestPOJO.setAmounts(res.getValue3());
        requestPOJO.setReciver(res.getValue4());
        return requestPOJO;
    }

    public Boolean setWaybillNumber(BigInteger num, String waybillNum) throws Exception {
        TransactionReceipt receipt = requestManager.setWayBillNum(num, waybillNum).send();
        if(receipt.isStatusOK()) {
            receipt = requestManager.setLockedMaterial(num).send();
            if(receipt.isStatusOK()) {
                return true;
            }
        }
        return false;
    }
}

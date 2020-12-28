package com.donationsystem.hospital.service;

import java.math.BigInteger;
import java.util.List;

import com.donationsystem.hospital.contract.HospitalMaterialManager;
import com.donationsystem.hospital.contract.RequestManager;
import com.donationsystem.hospital.util.RegistryTemplate;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private Credentials credentials;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private RegistryTemplate registryTemplate;

    @Autowired
    private HospitalMaterialManager hospitalMaterialManager;

    public BigInteger requestMaterial(List<BigInteger> varieties, List<BigInteger> amounts, String requestManagerName)
            throws Exception {
        RequestManager requestManager = managerService.getRequestManager(requestManagerName);
        if(requestManager == null) {
            throw new Exception("no such a requestManager");
        }
        if(!requestManager.showAllowed(hospitalMaterialManager.getContractAddress()).send()) {
            boolean res = registryTemplate.requestManagerAllowRegistry(hospitalMaterialManager.getContractAddress(), "172.100.0.6");
            if(!res) {
                throw new Exception("request allow error");
            }
        }
        TransactionReceipt receipt = hospitalMaterialManager.createReq(varieties, amounts, requestManager.getContractAddress()).send();
        if (receipt.isStatusOK()) {
            return hospitalMaterialManager.getCreateReqOutput(receipt).getValue1();
        }
        logger.error(receipt.getMessage() + " " + receipt.getStatus());
        return new BigInteger("-1");
    }

    public BigInteger getRequestStatus(BigInteger num, String requestManagerName) throws Exception {
        RequestManager requestManager = managerService.getRequestManager(requestManagerName);
        if(requestManager == null) {
            throw new Exception("no such a requestManager");
        }
        return requestManager.getReqState(num).send();
    }

    public String getWaybillNum(BigInteger num, String requestManagerName) throws Exception {
        RequestManager requestManager = managerService.getRequestManager(requestManagerName);
        if(requestManager == null) {
            throw new Exception("no such a requestManager");
        }
        return requestManager.getWayBillNum(num).send();
    }
}

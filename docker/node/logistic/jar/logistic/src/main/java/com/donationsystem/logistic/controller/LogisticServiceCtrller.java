package com.donationsystem.logistic.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donationsystem.logistic.service.NodeAccountService;
import com.donationsystem.logistic.service.WaybillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/logistic")
public class LogisticServiceCtrller {

    private static final Logger logger = LoggerFactory.getLogger(LogisticServiceCtrller.class);

    @Autowired
    private WaybillService waybillService;

    @Autowired
    private NodeAccountService nodeAccountService;

    @RequestMapping(value = "/deploy_by_material", method = RequestMethod.PUT)
    public boolean deployWayBill(@RequestParam(value = "nodeName", required = true) String nodeName,
            @RequestParam(value = "materialVarities", required = true) List<BigInteger> materialVarities,
            @RequestParam(value = "materialAmounts", required = true) List<BigInteger> materialAmounts) {
        String nodeId = nodeAccountService.getNodeAccount(nodeName).getNodeId();
        try {
            return waybillService.deployWayBill(nodeId, materialVarities, materialAmounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/deploy_by_address", method = RequestMethod.PUT)
    public boolean deployWayBill(@RequestParam(value = "nodeName", required = true) String nodeName,
            @RequestParam(value = "", required = true) List<String> materialAdresses) {
        String nodeId = nodeAccountService.getNodeAccount(nodeName).getNodeId();
        try {
            return waybillService.deployWayBill(nodeId, materialAdresses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

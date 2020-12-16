package com.donationsystem.logistic.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donationsystem.logistic.service.AddressService;
import com.donationsystem.logistic.service.WaybillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/logistic/waybill")
public class WaybillServiceController {

    private static final Logger logger = LoggerFactory.getLogger(WaybillServiceController.class);

    @Autowired
    private WaybillService waybillService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/deploy_by_material", method = RequestMethod.POST)
    public String deployWayBillByMaterial(@RequestParam(value = "nodeName", required = true) String nodeName,
            @RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts) {
        String nodeId;
        try {
            nodeId = addressService.getNodeAccount(nodeName);
        } catch (Exception e) {
            return "There is no such node";
        }
        try {
            return waybillService.deployWayBillByMaterial(nodeId, varieties, amounts);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/deploy_by_address", method = RequestMethod.POST)
    public String deployWayBillByAddress(@RequestParam(value = "nodeName", required = true) String nodeName,
            @RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts) {
        String nodeId;
        try {
            nodeId = addressService.getNodeAccount(nodeName);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        try {
            return waybillService.deployWayBillByAddress(nodeId, varieties, amounts);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/changeOwner", method = RequestMethod.POST)
    public Boolean setOwnerToRequester(@RequestParam(value = "number") String number,
            @RequestParam(value = "address") String address) {
        try {
            return waybillService.setOwnerToRequester(number, address);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }
}

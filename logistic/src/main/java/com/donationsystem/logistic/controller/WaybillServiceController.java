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

    @RequestMapping(value = "/deployByMaterial", method = RequestMethod.POST)
    public String deployWayBillByMaterial(@RequestParam(value = "reciverName", required = true) String reciverName,
            @RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts) {
        String reciverAddress;
        try {
            return waybillService.deployWayBillByMaterial(reciverName, varieties, amounts);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/deployByAddress", method = RequestMethod.POST)
    public String deployWayBillByAddress(@RequestParam(value = "reciverName", required = true) String reciverName,
            @RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts,
            @RequestParam(value = "foundationName", required = true) String foundationName) {
        String nodeId;
        try {
            return waybillService.deployWayBillByAddress(foundationName, varieties, amounts, foundationName);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}

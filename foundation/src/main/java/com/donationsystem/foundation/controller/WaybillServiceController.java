package com.donationsystem.foundation.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.donationsystem.foundation.service.WaybillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/foundation/waybill")
public class WaybillServiceController {

    private static final Logger logger = LoggerFactory.getLogger(WaybillServiceController.class);

    @Autowired
    private WaybillService waybillService;

    @RequestMapping(value = "/recive", method = RequestMethod.POST)
    public boolean reciveWayBill(@RequestParam(value = "number", required = true) String number, @RequestParam(value = "name", required = true) String name) {
        try {
            return waybillService.reciveWayBill(number, name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return false;
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.POST)
    public List<String> delivery(@RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts,
            @RequestParam(value = "address", required = true) String waybill) {
        try {
            return waybillService.delivery(varieties, amounts, waybill);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return new ArrayList<String>();
    }

    @RequestMapping(value = "/createWaybill", method = RequestMethod.POST)
    public String requestCreateWaybill(@RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts,
            @RequestParam(value = "nodeName", required = true) String nodeName) {
        return waybillService.RequestCreateWaybill(varieties, amounts, nodeName);
    }
}

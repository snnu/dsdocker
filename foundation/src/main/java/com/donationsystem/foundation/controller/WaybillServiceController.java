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
    public boolean reciveWayBill(@RequestParam(value = "number", required = true) String number,
            @RequestParam(value = "waybillManagerName", required = true) String waybillManagerName,
            @RequestParam(value = "reciver", required = true) String reciver) throws Exception {

        return waybillService.reciveWayBill(number, waybillManagerName, reciver);
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.POST)
    public List<String> delivery(@RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts,
            @RequestParam(value = "waybillManagerName", required = true) String waybillManagerName,
            @RequestParam(value = "number", required = true) String number) throws Exception {

        return waybillService.delivery(varieties, amounts, waybillManagerName, number);
    }
}

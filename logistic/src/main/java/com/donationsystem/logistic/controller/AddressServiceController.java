package com.donationsystem.logistic.controller;

import com.donationsystem.logistic.service.AddressService;
import com.donationsystem.logistic.service.WaybillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/logistic/address")
public class AddressServiceController {
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceController.class);

    @Autowired
    private WaybillService waybillService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/getWaybillAddress", method = RequestMethod.GET)
    public String getWaybillAddress(@RequestParam(value = "number", required = true) String number) {
        try {
            return waybillService.findWayBillAddress(number);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/nodeRegistry", method = RequestMethod.POST)
    public Boolean registryNodeAccount() {
        try {
            return addressService.registryNodeAccount();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @RequestMapping(value = "/waybillRegistry", method = RequestMethod.POST)
    public Boolean registryWayBillManager() {
        try {
            return addressService.registryWaybillManager();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }
}

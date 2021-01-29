package com.donationsystem.hospital.controller;

import com.donationsystem.hospital.service.WaybillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/hospital/waybill")
public class WaybillServiceController {

    private static final Logger logger = LoggerFactory.getLogger(WaybillServiceController.class);

    @Autowired
    private WaybillService waybillService;

    @RequestMapping(value = "/recive", method = RequestMethod.POST)
    public Boolean reciveMaterial(@RequestParam(value = "number", required = true) String number,
            @RequestParam(value = "waybillManagerName", required = true) String waybillManagerName,
            @RequestParam(value = "reciver", required = true) String reciver) {
        try {
            return waybillService.reciveMaterial(number, waybillManagerName, reciver);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

package com.donationsystem.hospital.controller;

import com.donationsystem.hospital.service.WaybillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaybillServiceController {

    private static final Logger logger = LoggerFactory.getLogger(WaybillServiceController.class);

    @Autowired
    private WaybillService waybillService;

    public Boolean reciveMaterial(String number, String name) {
        try {
            return waybillService.reciveMaterial(number, name);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}

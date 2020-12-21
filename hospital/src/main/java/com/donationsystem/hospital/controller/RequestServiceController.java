package com.donationsystem.hospital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import com.donationsystem.hospital.service.RequestService;

@RestController
@RequestMapping(value = "v1/hopital/request")
public class RequestServiceController {

    private static final Logger logger = LoggerFactory.getLogger(RequestServiceController.class);

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/requestMaterials", method = RequestMethod.POST)
    public BigInteger requestMaterials(@RequestParam(value = "varieties", required = true) List<BigInteger> varieties,
            @RequestParam(value = "amounts", required = true) List<BigInteger> amounts,
            @RequestParam(value = "requestManagerName", required = true) String requestManagerName) {
        try {
            return requestService.requestMaterial(varieties, amounts, requestManagerName);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new BigInteger("-1");
        }
    }

    @RequestMapping(value = "/getRequestStatus", method = RequestMethod.POST)
    public BigInteger getRequestStatus(@RequestParam(value = "num", required = true) BigInteger num,
            @RequestParam(value = "requestManagerName", required = true) String requestManagerName) {
        try {
            return requestService.getRequestStatus(num, requestManagerName);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new BigInteger("-1");
        }
    }

    @RequestMapping(value = "/getWaybillNum", method = RequestMethod.POST)
    public String getWaybillNum(@RequestParam(value = "num", required = true) BigInteger num,
            @RequestParam(value = "requestManagerName", required = true) String requestManagerName) {
        try {
            return requestService.getWaybillNum(num, requestManagerName);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "";
        }
    }
}

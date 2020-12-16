package com.donationsystem.foundation.controller;

import java.math.BigInteger;

import com.donationsystem.foundation.contract.LocationManager;
import com.donationsystem.foundation.model.RequestPOJO;
import com.donationsystem.foundation.service.RequestService;
import com.donationsystem.foundation.service.WaybillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/foundation/request")
public class RquestServiceController {

    private static final Logger logger = LoggerFactory.getLogger(RquestServiceController.class);

    @Autowired
    private RequestService requestService;

    @Autowired
    private LocationManager locationManager;

    @Autowired
    private WaybillService waybillService;

    @RequestMapping(value = "/getNextRequest", method = RequestMethod.GET)
    @ResponseBody
    public RequestPOJO getNextRequest() {
        try {
            return requestService.getNextRequest();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return new RequestPOJO();
    }

    @RequestMapping(value = "/setState", method = RequestMethod.POST)
    public Boolean setState2Request(BigInteger state) {
        try {
            return requestService.setState(state);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @RequestMapping(value = "/sendMaterial", method = RequestMethod.POST)
    public String sendMaterial() {
        try {
            RequestPOJO requestPOJO = requestService.getNextAgreedRequest();
            String reciver = locationManager.getAddress(requestPOJO.getReciver()).send();
            String waybillNumber = waybillService.RequestCreateWaybill(requestPOJO.getVarieties(),
                    requestPOJO.getAmounts(), reciver);
            requestService.setWaybillNumber(requestPOJO.getNum(), waybillNumber);
            return waybillNumber;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return "";
    }
}

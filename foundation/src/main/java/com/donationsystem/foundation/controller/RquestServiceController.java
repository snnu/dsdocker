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
import org.springframework.web.bind.annotation.RequestParam;
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
    public RequestPOJO getNextRequest() throws Exception {
        return requestService.getNextRequest();
    }

    @RequestMapping(value = "/setState", method = RequestMethod.POST)
    public Boolean setState2Request(@RequestParam(value = "state", required = true) BigInteger state) throws Exception {
        return requestService.setState(state);
    }

    @RequestMapping(value = "/sendMaterial", method = RequestMethod.POST)
    public String sendMaterial(@RequestParam(value = "logisticName", required = true) String logisticName,
            @RequestParam(value = "deliveryman", required = true) String deliveryman) throws Exception {
        RequestPOJO requestPOJO = requestService.getNextAgreedRequest();
        logger.debug("request num: " + requestPOJO.getNum().toString());
        String waybillNumber = waybillService.RequestCreateWaybill(requestPOJO.getVarieties(), requestPOJO.getAmounts(),
                requestPOJO.getReciver(), logisticName, deliveryman);
        requestService.setWaybillNumber(requestPOJO.getNum(), waybillNumber);
        return waybillNumber;
    }
}

package com.donationsystem.platform.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.donationsystem.platform.service.WaybillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/platform/waybill")
public class WaybillServiceController {

    @Autowired
    private WaybillService waybillService;

    @RequestMapping(value = "/getStatusByNumber", method = RequestMethod.POST)
    @ResponseBody
    public Map<BigInteger, List<String[]>> getStatusByNumber(@RequestParam(value = "waybillNumber", required = true) String waybillNumber,
            @RequestParam(value = "waybillManagerName", required = true) String waybillManagerName) {
        try {
            return waybillService.getStatusByNumber(waybillNumber, waybillManagerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

}

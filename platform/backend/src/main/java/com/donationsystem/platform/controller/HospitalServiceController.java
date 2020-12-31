package com.donationsystem.platform.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.donationsystem.platform.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/platform/hospital")
public class HospitalServiceController {
    
    @Autowired
    private HospitalService hospitalService;

    @PostMapping(value = "/getVarietiesAmounts")
    public Map<BigInteger, BigInteger> getVarietiesAmounts(@RequestParam(value = "varieties", required = true) List<BigInteger> varieties, @RequestParam(value = "hospitalMaterialManagerName", required = true) String hospitalMaterialManagerName) {
        try {
            return hospitalService.getHospitalMaterialAmounts(varieties, hospitalMaterialManagerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

}

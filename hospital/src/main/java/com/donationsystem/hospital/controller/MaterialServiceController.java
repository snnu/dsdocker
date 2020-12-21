package com.donationsystem.hospital.controller;

import java.math.BigInteger;
import java.util.List;

import com.donationsystem.hospital.model.MaterialPOJO;
import com.donationsystem.hospital.service.MaterialService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/hospital/material")
public class MaterialServiceController {

    private static final Logger logger = LoggerFactory.getLogger(MaterialServiceController.class);

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/getMaterialAmounts", method = RequestMethod.POST)
    @ResponseBody
    public List<MaterialPOJO> getMaterialAmounts(
            @RequestParam(value = "varieties", required = true) List<BigInteger> varieties) throws Exception {
        return materialService.getMaterialAmounts(varieties);
    }

    @RequestMapping(value = "/useMaterial", method = RequestMethod.GET)
    public Boolean useMaterial(@RequestParam(value = "variety", required = true) BigInteger variety, 
    @RequestParam(value = "amount", required = true) BigInteger amount) {
        try {
            return materialService.useMaterial(variety, amount);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }
}

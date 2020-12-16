package com.donationsystem.foundation.controller;

import java.math.BigInteger;
import java.util.List;

import com.donationsystem.foundation.model.MaterialPOJO;
import com.donationsystem.foundation.service.MaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/foundation/material")
public class MaterialServiceController {
    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/getMaterialAmounts", method = RequestMethod.POST)
    @ResponseBody
    public List<MaterialPOJO> getMaterialAmounts(
            @RequestParam(value = "varieties", required = true) List<BigInteger> varieties) throws Exception {
        return materialService.getMaterialAmounts(varieties);
    }
}

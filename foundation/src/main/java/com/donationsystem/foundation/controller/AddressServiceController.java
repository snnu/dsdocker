package com.donationsystem.foundation.controller;

import com.donationsystem.foundation.service.AddressService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/foundation/address")
public class AddressServiceController {

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceController.class);

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/nodeRegistry", method = RequestMethod.POST)
    public Boolean registryNodeAccount() throws Exception {

        return addressService.registryNodeAccount();

    }

    @RequestMapping(value = "/foundationMaterialManagerRegistry", method = RequestMethod.POST)
    public Boolean registryFoundationoMaterialManager() throws Exception {

        return addressService.registryFoundationMaterialManager();

    }

    @RequestMapping(value = "/requestManagerRegistry", method = RequestMethod.POST)
    public Boolean regsictryRequestManager() throws Exception {

        return addressService.registryRequestManager();

    }

    @RequestMapping(value = "/allowHospital", method = RequestMethod.POST)
    public Boolean allowHospital(@RequestParam(value = "address", required = true) String address) throws Exception {

        return addressService.allowHospital(address);

    }

    @RequestMapping(value = "/disallowHospital", method = RequestMethod.POST)
    public Boolean disallowHospital(@RequestParam(value = "address", required = true) String address) throws Exception {

        return addressService.disallowHospital(address);

    }
}

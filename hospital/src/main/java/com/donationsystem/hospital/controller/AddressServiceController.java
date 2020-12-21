package com.donationsystem.hospital.controller;

import com.donationsystem.hospital.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressServiceController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/nodeRegistry", method = RequestMethod.POST)
    public Boolean registryNodeAccount() throws Exception {
        return addressService.registryNodeAccount();
    }

    @RequestMapping(value = "/hospitalMaterialManagerRegistry", method = RequestMethod.POST)
    public Boolean registryHospitalMaterialManager() throws Exception {
        return addressService.registryHospitalMaterialManager();
    }
}

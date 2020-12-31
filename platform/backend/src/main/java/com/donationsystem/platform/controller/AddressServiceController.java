package com.donationsystem.platform.controller;

import com.donationsystem.platform.service.RegistryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/platform/address")
public class AddressServiceController {

    @Autowired
    private RegistryService registryService;

    @RequestMapping(value = "/allowRegistryAddress", method = RequestMethod.POST)
    public Boolean registryAddress(@RequestParam(name = "address", required = true) String address) {
        try {
            return registryService.allowRegistryAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/disallowRegistryAddress", method = RequestMethod.POST)
    public Boolean disregistryAddress(@RequestParam(name = "address", required = true) String address) {
        try {
            return registryService.disallowRegistryAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
       

    @RequestMapping(value = "/getLocationManagerAddress", method = RequestMethod.GET) 
    public String getLocationManagerAddress() {
        return registryService.getLocationManagerAddress();
    }
}

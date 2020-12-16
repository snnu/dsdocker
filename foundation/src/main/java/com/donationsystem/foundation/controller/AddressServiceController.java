package com.donationsystem.foundation.controller;

import com.donationsystem.foundation.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/foundation/address")
public class AddressServiceController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/nodeRegistry")
    public Boolean registryNodeAccount() throws Exception {
        return addressService.registryNodeAccount();
    }

    @RequestMapping(value = "/foundationMaterialManagerRegistry")
    public Boolean registryFoundationoMaterialManager() throws Exception {
        return addressService.registryFoundationMaterialManager();
    }

    @RequestMapping(value = "/requestManager")
    public Boolean regsictryRequestManager() throws Exception {
        return addressService.registryRequestManager();
    }
}

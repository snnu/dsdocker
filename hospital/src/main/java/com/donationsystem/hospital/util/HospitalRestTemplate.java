package com.donationsystem.hospital.util;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import com.donationsystem.hospital.contract.HospitalMaterialManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HospitalRestTemplate {
    private static final Logger logger = LoggerFactory.getLogger(HospitalRestTemplate.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private HospitalMaterialManager hospitalMaterialManager;

    public Boolean RequestOwnerChange(String number) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("number", number);
        params.add("address", hospitalMaterialManager.getContractAddress());
        String url = "http://localhost:8082/v1/logistic/waybill/changeOwner";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<Boolean> restExchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Boolean.class);
        return restExchange.getBody();
    }
}

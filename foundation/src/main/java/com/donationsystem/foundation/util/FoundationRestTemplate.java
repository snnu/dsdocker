package com.donationsystem.foundation.util;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import com.donationsystem.foundation.contract.FoundationMaterialManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class FoundationRestTemplate {

    private static final Logger logger = LoggerFactory.getLogger(FoundationRestTemplate.class);

    @Autowired
    private FoundationMaterialManager foundationMaterialManager;

    private RestTemplate restTemplate = new RestTemplate();

    public Boolean RequestOwnerChange(String number) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("number", number);
        params.add("address", foundationMaterialManager.getContractAddress());
        String url = "http://localhost:8082/v1/logistic/waybill/changeOwner";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<Boolean> restExchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Boolean.class);
        return restExchange.getBody();
    }

    public String RequestCreateWaybill(List<BigInteger> varieties, List<BigInteger> amounts, String nodeName) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("nodeName", nodeName);
        params.add("varieties", varieties.stream().map(Object::toString).collect(Collectors.joining(",")));
        params.add("amounts", amounts.stream().map(Object::toString).collect(Collectors.joining(",")));
        String url = "http://localhost:8082/v1/logistic/waybill/deploy_by_address";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<String> restExchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return restExchange.getBody();
    }
}

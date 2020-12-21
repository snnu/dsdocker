package com.donationsystem.logistic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RegistryTemplate {

    private static final Logger logger = LoggerFactory.getLogger(RegistryTemplate.class);

    private RestTemplate restTemplate = new RestTemplate();

    public Boolean allowRegistryWaybillManager(String address, String platformIP) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("address", address);
        String url = String.format("http://%s:8080/v1/platform/address/allowRegistryAddress", platformIP);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Boolean.class);
        return responseEntity.getBody();
    }
}

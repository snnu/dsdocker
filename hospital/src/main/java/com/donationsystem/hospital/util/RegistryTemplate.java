package com.donationsystem.hospital.util;

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

    private RestTemplate restTemplate = new RestTemplate();

    public Boolean locationManagerAllowRegistry(String address, String platformIP) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("address", address);
        String url = String.format("http://%s:8080/v1/platform/address/allowRegistryAddress", platformIP);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Boolean.class);
        return responseEntity.getBody();
    }

    public Boolean requestManagerAllowRegistry(String address, String foundationIP) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("address", address);
        String url = String.format("http://%s:8080/v1/foundation/address/allowHospital", foundationIP);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Boolean.class);
        return responseEntity.getBody();
    }
}

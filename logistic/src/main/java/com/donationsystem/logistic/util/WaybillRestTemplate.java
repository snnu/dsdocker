package com.donationsystem.logistic.util;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import com.donationsystem.logistic.contract.WaybillManager;

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
public class WaybillRestTemplate {

    @Autowired
    private WaybillManager waybillManager;
    
    private RestTemplate restTemplate = new RestTemplate();

    public List<String> requestMaterial(List<BigInteger> varieties, List<BigInteger> amounts, String number, String foundationIP)
            throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("varieties", varieties.stream().map(Object::toString).collect(Collectors.joining(",")));
        params.add("amounts", amounts.stream().map(Object::toString).collect(Collectors.joining(",")));
        params.add("waybillManagerName", "waybillManager");
        params.add("number", number);
        String url = String.format("http://%s:8080/v1/foundation/waybill/delivery", foundationIP) ;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, List.class);
        return responseEntity.getBody();
    }
}

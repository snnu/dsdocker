package com.donationsystem.logistic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.donationsystem.logistic.contract.LocationManager;
import com.donationsystem.logistic.contract.WaybillManager;
import com.google.common.collect.Lists;

@Service
public class DBInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired 
    private LocationManager locationManager;

    @Autowired 
    private WaybillManager waybillManager;

    @PostConstruct
    public void init() throws Exception {
        logger.info("===DB Initializing===");
        
        logger.info("===DB Initialized===");
    }
}

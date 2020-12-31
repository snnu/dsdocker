package com.donationsystem.platform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

import com.donationsystem.platform.contract.LocationManager;

@Service
public class DBInitializer {

    private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    @PostConstruct
    public void initDB() throws Exception {
        logger.info("Starting database initialization...");
        
        logger.info("Database initialization finished.");
    }
}
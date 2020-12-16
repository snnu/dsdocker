package com.donationsystem.hospital.service;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import com.donationsystem.hospital.repository.ManagerRepo;

@Service
public class DBInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired
    private ManagerRepo managerRepo;

    @PostConstruct
    public void init() {
        logger.info("===DB Initializing===");
        logger.info("===DB Initialized===");
    }
}

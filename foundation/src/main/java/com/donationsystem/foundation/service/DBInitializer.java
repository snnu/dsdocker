package com.donationsystem.foundation.service;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.annotation.PostConstruct;

import com.donationsystem.foundation.repository.ManagerRepo;
import com.google.common.collect.Lists;

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

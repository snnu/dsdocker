package com.donationsystem.foundation.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class DataFormattor {
    @Bean
    public SimpleDateFormat getDataFormattor() {
        return new SimpleDateFormat("yyyyMMddhhmmss");
    }
}

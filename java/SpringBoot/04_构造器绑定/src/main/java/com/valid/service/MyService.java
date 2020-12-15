package com.valid.service;

import com.valid.model.AnotherComponent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Bean
    @ConfigurationProperties("acme")
    public AnotherComponent getAnotherComponent() {
        return new AnotherComponent();
    }
}

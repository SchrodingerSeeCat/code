package com.valid.profile.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Component
@Profile("test")
@ConfigurationProperties("person")
public class Worker implements Person{
    private String name;
    private Integer age;
}

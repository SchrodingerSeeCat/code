package com.valid.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ValueProperties {

    @Value("${person.first-name}")
    private String firstName;

    @Value("#{2 * 3}")
    private int age;

    private String email;
}

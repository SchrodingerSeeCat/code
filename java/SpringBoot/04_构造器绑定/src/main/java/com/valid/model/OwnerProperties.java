package com.valid.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@ConfigurationProperties("acme.my-person.person") // 在属性类中，前缀不可以是驼峰模式，只能使用羊肉串模式
@Component
@Validated
public class OwnerProperties {

    @NotNull
    private String firstName;

    @Max(35)
    private int age;

    @Email
    private String email;
}

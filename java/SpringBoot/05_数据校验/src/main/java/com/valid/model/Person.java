package com.valid.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@Component
@ConfigurationProperties("person")
@Validated
public class Person {
    // 普通属性校验

    @NotNull
    private String firstName;
    @Max(18)
    private int age;
    @Email
    private String email;

    // 内部类校验
    @Valid
    private School school = new School();

    @Data
    class School{
        @NotNull
        private String sname;
    }
}

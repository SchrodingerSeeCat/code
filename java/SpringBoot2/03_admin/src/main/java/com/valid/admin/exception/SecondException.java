package com.valid.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "第二种异常处理方式")
public class SecondException extends RuntimeException{

    public SecondException() {}
    public SecondException(String message) {
        super(message);
    }
}

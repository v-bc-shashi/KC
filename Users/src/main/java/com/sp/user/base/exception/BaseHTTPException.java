package com.sp.user.base.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Getter
public abstract  class BaseHTTPException extends  RuntimeException {

    protected List<ErrorResponse.FieldError> fieldErrors;

    public BaseHTTPException(String message){
        super(message);
    }
    public abstract HttpStatusCode statusCode();
}

package com.sp.user.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class EntityNotFoundException extends  BaseHTTPException{
    private static final String MESSAGE_TEMPLATE = "%s with given parameter(s) not found";
    public EntityNotFoundException(String entityName) {
        super(String.format(MESSAGE_TEMPLATE, entityName));
    }

    public EntityNotFoundException() {
        super(String.format(MESSAGE_TEMPLATE, "Entity"));
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatus.NOT_FOUND;
    }
}

package com.sp.user.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class EntityAlreadyExistException extends  BaseHTTPException{
    private static final String MESSAGE_TEMPLATE = "%s with given parameter(s) Already exist";
    public EntityAlreadyExistException(String entityName) {
        super(String.format(MESSAGE_TEMPLATE, entityName));
    }

    public EntityAlreadyExistException() {
        super(String.format(MESSAGE_TEMPLATE, "Entity"));
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatus.NOT_FOUND;
    }
}

package com.sp.user.shared;

import com.sp.user.base.exception.BaseHTTPException;
import com.sp.user.base.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

public class InvalidInputException extends BaseHTTPException {

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(Map<String, String> payLoadKeyErrorMap) {
       super("Invalid Inputs");
       if(payLoadKeyErrorMap!=null && !payLoadKeyErrorMap.isEmpty()){
           this.fieldErrors=payLoadKeyErrorMap.entrySet().stream().map(ErrorResponse.FieldError::new).toList();
       }
    }

    @Override
    public HttpStatusCode statusCode(){
        return HttpStatus.BAD_REQUEST;
    }
}

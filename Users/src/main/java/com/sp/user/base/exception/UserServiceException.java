package com.sp.user.base.exception;

public class UserServiceException extends  Exception {
    private static final long serialVersionUID = 1L;

    public UserServiceException(String message){
        super(message);
    }
}

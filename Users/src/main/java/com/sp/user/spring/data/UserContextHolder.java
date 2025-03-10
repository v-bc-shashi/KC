package com.sp.user.spring.data;

import lombok.NonNull;

public class UserContextHolder {

    private static final ThreadLocal<String> _contextHolder= new ThreadLocal<>();

    public static void setEmail(@NonNull String email){
        _contextHolder.set(email.toUpperCase());
    }

    public static String getUserEmail(){
        //return _contextHolder.get();
        return "Shashi.prashad@gmil.com";
    }

}

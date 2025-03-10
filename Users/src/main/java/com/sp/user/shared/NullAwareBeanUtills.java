package com.sp.user.shared;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class NullAwareBeanUtills extends BeanUtilsBean {
   public  void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException{
        super.copyProperty(dest, name,value);
   }
}

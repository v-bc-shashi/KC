package com.sp.user.base.dto;

import lombok.Data;

import java.util.List;

@Data
public class BaseEntityResponse <E>{
    private Integer count;
    public List<E> list;
}

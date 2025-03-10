package com.sp.user.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.dto.BaseDTO;
import com.sp.user.base.entity.BaseEntity;
import com.sp.user.base.service.BaseService;

public class BaseController<E extends BaseEntity, P, D extends BaseDTO> {

   protected final BaseService<E,D,P> service;
   protected final ObjectMapper objectMapper;

   public BaseController(BaseService<E,D,P> baseService , ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
        this.service= baseService;
   }


}

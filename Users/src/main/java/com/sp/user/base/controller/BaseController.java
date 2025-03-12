package com.sp.user.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.dto.BaseDTO;
import com.sp.user.base.entity.BaseEntity;
import com.sp.user.base.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class BaseController<E extends BaseEntity, P, D extends BaseDTO> {

   protected final BaseService<E,D,P> service;
   protected final ObjectMapper objectMapper;

   public BaseController(BaseService<E,D,P> baseService , ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
        this.service= baseService;
   }

   @PostMapping()
   public ResponseEntity<? extends  D> createEntity(@RequestBody D dto){
       var resultDTO = this.service.saveEntity(dto, false);
       return ResponseEntity.ok(resultDTO);
   }

    @PatchMapping
    public ResponseEntity<?extends D> updateEntity(@RequestBody D dto){
       var resultDto= this.service.saveEntity(dto, true);
       return ResponseEntity.ok(resultDto);
    }

    @PostMapping
    public ResponseEntity<?> bulkUpload(@RequestParam("file") MultipartFile file){

        return ResponseEntity.ok("done");
    }
}

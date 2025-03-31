package com.sp.user.base.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.dto.BaseDTO;
import com.sp.user.base.entity.BaseEntity;
import com.sp.user.base.repository.BaseRepository;
import com.sp.user.module.employee.controller.EmployeeResponse;
import com.sp.user.module.employee.utils.CommonConstants;
import com.sp.user.module.employee.utils.ExcelImporter;
import com.sp.user.module.employee.utils.NullAwareBeanUtills;
import com.sp.user.spring.data.UserContextHolder;
import lombok.SneakyThrows;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public abstract class BaseService <E extends BaseEntity, D extends BaseDTO, P> {
    protected static final NullAwareBeanUtills nullAwareBeanUtils= new NullAwareBeanUtills();
    protected  final ObjectMapper objectMapper;
    protected final  BaseRepository<E,P> repository;
    private  final Class<D> dClass;
    private  final Class<E> eClass;
    private final String entityName;
    protected  final ExcelImporter excelImporter;
    protected BaseService(ObjectMapper objectMapper, Class<D> dClass, Class<E> eClass, String entityName, BaseRepository<E, P> repository, ExcelImporter excelImporter) {
        this.objectMapper = objectMapper;
        this.repository = repository;
        this.dClass = dClass;
        this.eClass = eClass;
        this.entityName = entityName;
        this.excelImporter = excelImporter;
    }


    protected Optional<E> findExistingEntity(D dto) {
        P primaryKey = this.getPrimaryKey(dto);
        return repository.findById(primaryKey);
    }


public abstract P getPrimaryKey(D dto);

    protected  boolean doesItemExists(D dto){
        P key= this.getPrimaryKey(dto);
        if(key==null){
            return false;
        }
        return repository.findById(key).isPresent();
    }

    public D convertToDTO(E entity){
        return this.objectMapper.convertValue(entity, dClass);
    }

    protected E convertToEntity(D dto){
        return this.objectMapper.convertValue(dto, eClass);
    }




    protected D generatedResponseDTO(D d){
        return d;
    }

    protected void preSaveOps(D dto, boolean isUpdateOp){

    }

    protected void preSaveOps(E entity, boolean isUpdateOp, D tempDto){

    }

    protected void preCreateOps(D dto){

    }

    protected void preUpdateOps(){

    }

    protected void postSaveOps(D dto, boolean isUpdateOp){

    }

    protected void postSaveOps(E entity, boolean isUpdateOp){

    }


    protected boolean isPaginationEnabled(){
        return false;
    }

    protected int pageSize(){
        return 100;
    }

    protected boolean filterEntity(E entity){
        return true;
    }

    protected boolean filterResponseDTO(D dto){
        return true;
    }

    protected boolean hadConflict(D dto){
        return false;
    }
    protected boolean isBulkCreationEntytiesEnabled(){
        return false;
    }

    protected D generateResponseDTO(D d) {
        return d;
    }

    @Transactional
    public ResponseEntity<Object>  createEntity(D dto, boolean isUpdate) {
        return EmployeeResponse.responceBuilder(CommonConstants.RECORD_CREATED_SUCCESSFULLY, HttpStatus.CREATED, this.generateResponseDTO(dto));
    }

   protected int getDefaultPageSize(){
        return 10;
   }

    @SneakyThrows
    protected void patch(E existingDTO, D requestDto){
        nullAwareBeanUtils.copyProperties(existingDTO, requestDto);
    }

    protected List<Pair<String, String>> getExcelImportColumns() {
        return Collections.emptyList();
    }
    protected boolean allowBulkUpdate() {
        return true;
    }
    protected final List<String> EXCLUDED = List.of(
            "creationUserId",
            "updateUserId",
            "creationDate",
            "lastUpdateDate"
    );




}

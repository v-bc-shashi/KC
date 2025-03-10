package com.sp.user.base.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.dto.BaseDTO;
import com.sp.user.base.entity.BaseEntity;
import com.sp.user.base.repository.BaseRepository;
import com.sp.user.shared.NullAwareBeanUtills;
import com.sp.user.spring.data.UserContextHolder;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public abstract class BaseService <E extends BaseEntity, D extends BaseDTO, P> {
    protected static final NullAwareBeanUtills nullAwareBeanUtils= new NullAwareBeanUtills();
    protected  final ObjectMapper objectMapper;
    protected final  BaseRepository<E,P> repository;
    private  final Class<D> dClass;
    private  final Class<E> eClass;
    private final String entityName;
    protected BaseService(ObjectMapper objectMapper, Class<D> dClass, Class<E> eClass, String entityName, BaseRepository<E, P> repository) {
        this.objectMapper = objectMapper;
        this.repository = repository;
        this.dClass = dClass;
        this.eClass = eClass;
        this.entityName = entityName;
    }

/*
public List<D> getAllEntity(Integer pageNumber, Integer pageSize){
        List<E> entities= new ArrayList<>();
        var email= UserContextHolder.getUserEmail().toUpperCase();

        if(this.isPaginationEnabled() ){
            if(pageSize ==null || pageSize<=0){
                pageSize=this.getDefaultPageSize();
            }

            if(pageNumber==null || pageNumber<0 )
                pageNumber=0;
        }

        var pageRequest= PageRequest.of(pageNumber, pageSize);
        var page = repository.findAll();

     entities.addAll(page.);

     return entities.stream()
             .filter(this::filterEntity)
             .sorted(Comparator.nullsFirst(Comparator.comparing(BaseEntity::getLastUpdateDate))
             .thenComparing(Comparator.nullsFirst(Comparator.comparing(BaseEntity::getCreationDate)))
                     .reversed())
             .map(this::convertToDTO)
             .map(this::generatedResponseDTO)
             .filter(this::filterResponseDTO)
             .toList();
}
*/

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

    private Optional<E> findExistingEntity(D dto){
        P primarykey= this.getPrimaryKey(dto);
        return repository.findById(primarykey);
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

    protected D _saveEntity(D dto, boolean isUpdateOp, boolean ignoreExistence){
        D tempDTO = dto;
        E entityToSave;
        if(isUpdateOp){
            entityToSave= this.findExistingEntity(dto).orElse(null);

            if(ignoreExistence){
                entityToSave=this.convertToEntity(dto);
            }

            if(entityToSave.getCreationDate() != null){
                dto.setCreationDate(entityToSave.getCreationDate());
            }
            this.patch(entityToSave, dto);
         } else {

           if(!ignoreExistence ){
               if(this.hadConflict(dto) || this.doesItemExists(dto)){

               }
           }

           entityToSave=this.convertToEntity(dto);
           entityToSave.setCreationUserId(UserContextHolder.getUserEmail());
        }
        entityToSave.setCreationUserId(UserContextHolder.getUserEmail());
        this.preSaveOps(dto, isUpdateOp);
        this.preSaveOps(entityToSave, isUpdateOp, tempDTO);

        var entity= repository.save(entityToSave);
        this.postSaveOps(entity, isUpdateOp);
        this.postSaveOps(dto, isUpdateOp);
        return this.generatedResponseDTO(this.convertToDTO(entity));
    }

   protected int getDefaultPageSize(){
        return 10;
   }

    @SneakyThrows
    protected void patch(E existingDTO, D requestDto){
        nullAwareBeanUtils.copyProperties(existingDTO, requestDto);
    }
}

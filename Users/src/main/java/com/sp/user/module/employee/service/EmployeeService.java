package com.sp.user.module.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.exception.EntityAlreadyExistException;
import com.sp.user.base.exception.EntityNotFoundException;
import com.sp.user.base.exception.UserServiceException;
import com.sp.user.base.service.BaseService;
import com.sp.user.module.employee.constants.EmployeeConstants;
import com.sp.user.module.employee.controller.EmployeeResponse;
import com.sp.user.module.employee.dto.EmployeeDTO;
import com.sp.user.module.employee.entity.EmployeeEntity;
import com.sp.user.module.employee.repository.EmployeeRepository;
import com.sp.user.module.employee.utils.CommonConstants;
import com.sp.user.module.employee.utils.CommonUtils;
import com.sp.user.module.employee.utils.ExcelGeneratorUtil;
import com.sp.user.module.employee.utils.ExcelImporter;
import com.sp.user.spring.data.UserContextHolder;
import lombok.SneakyThrows;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class EmployeeService extends BaseService<EmployeeEntity, EmployeeDTO, EmployeeEntity.PrimaryKey> {

    private final EmployeeRepository repository;

    public EmployeeService(ObjectMapper objectMapper, EmployeeRepository employeeRepository, ExcelImporter excelImporter) {
        super(objectMapper, EmployeeDTO.class, EmployeeEntity.class, EmployeeConstants.ENTITY_NAME, employeeRepository, excelImporter);
        this.repository = employeeRepository;
    }

    @Override
    public EmployeeEntity.PrimaryKey getPrimaryKey(EmployeeDTO empdto) {
        return new EmployeeEntity.PrimaryKey(empdto.getEmployeeId(), empdto.getEmailId());
    }


    public List<EmployeeDTO> getAllEmployee(Integer pageNumber, Integer pageSize) {
        List<EmployeeEntity> entities = new ArrayList<>();
        var email = UserContextHolder.getUserEmail().toUpperCase();

        if (this.isPaginationEnabled()) {
            if (pageSize == null || pageSize <= 0) {
                pageSize = this.getDefaultPageSize();
            }

            if (pageNumber == null || pageNumber < 0)
                pageNumber = 0;
        }

        var pageRequest = PageRequest.of(pageNumber, pageSize);
        var page = repository.findAll(pageRequest);

        entities.addAll(page.getContent());

        return entities.stream()
                .sorted(Comparator.nullsFirst(Comparator.comparing(EmployeeEntity::getLastUpdateDate))
                        .thenComparing(Comparator.nullsFirst(Comparator.comparing(EmployeeEntity::getCreationDate)))
                        .reversed())
                .map(this::convertToDTO)
                .map(this::generatedResponseDTO)
                .filter(this::filterResponseDTO)
                .toList();
    }


    @Override
    @Transactional
    public ResponseEntity<Object> createEntity(EmployeeDTO dto, boolean isUpdatable) {
        EmployeeEntity entityToSave;
        EmployeeEntity Savedentity;
        try {
            if (this.doesItemExists(dto) && !isUpdatable) {
                throw new EntityAlreadyExistException(dto.getEmployeeId() + " - " + dto.getEmailId());
            }
            if (isUpdatable) {
                entityToSave = this.findExistingEntity(dto).orElse(null);
                if (entityToSave == null) {
                    throw new EntityNotFoundException(dto.getEmployeeId() + " - " + dto.getEmailId());
                }

                if (entityToSave.getCreationDate() != null) {
                    dto.setCreationDate(entityToSave.getCreationDate());
                }
                this.patch(entityToSave, dto);
                entityToSave = this.convertToEntity(dto);
                entityToSave.setUpdateUserId(UserContextHolder.getUserEmail());
                Savedentity = repository.save(entityToSave);
            } else {

                this.preCreateOps(dto);
                //    this.preSaveOps(dto);
                entityToSave = this.convertToEntity(dto);
                entityToSave.setCreationUserId(UserContextHolder.getUserEmail());
                Savedentity = repository.save(this.convertToEntity(dto));
                //this.postSaveOps(entity);
            }
          //  return this.convertToDTO(Savedentity);
            return EmployeeResponse.responceBuilder(CommonConstants.RECORD_CREATED_SUCCESSFULLY, HttpStatus.CREATED, this.generateResponseDTO(this.convertToDTO(Savedentity)));
        } catch (Exception exception) {
            System.out.println(exception.getCause());
            System.out.println(exception);
           // return null;
            return EmployeeResponse.responceBuilder(exception.getMessage(), HttpStatus.EXPECTATION_FAILED, dto);
        }
    }

    @SneakyThrows
    @Transactional
    public Map<String, String> bulkUpload(MultipartFile file) {
        int count = 0;
        Map<String, String> recordStatus = new HashMap<>();
        List<EmployeeEntity> employeeEntities= CommonUtils.convertToEntity(file, EmployeeEntity.class,
                ExcelGeneratorUtil.UPLOAD_Employee_COLUMNS);
        try {
            for (EmployeeEntity entity : employeeEntities) {
                recordStatus.put(entity.getEmployeeId(),"Failed");
                if (this.doesItemExists(this.convertToDTO(entity))) {
                    var entityExist =this.findExistingEntity(this.convertToDTO(entity)).orElse(null);
                    System.out.println("This is already Exist "+  entity.getEmployeeId()+" - "+entity.getEmailId() );
                } else {
                    entity.setCreationUserId(UserContextHolder.getUserEmail());
                    repository.save(entity);
                    recordStatus.put(entity.getEmployeeId(),"Success");
                }
            }
            count++;
        } catch (DataIntegrityViolationException dive) {
            throw new UserServiceException(CommonConstants.INTEGRATION_VIOLATION_MSG_STR + " -" + employeeEntities.get(count).getEmployeeId());

        }
      return  recordStatus;
    }
} //END Of CLASS



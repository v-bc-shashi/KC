package com.sp.user.module.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.dto.BaseDTO;
import com.sp.user.base.service.BaseService;
import com.sp.user.module.employee.constants.EmployeeConstants;
import com.sp.user.module.employee.dto.EmployeeDTO;
import com.sp.user.module.employee.entity.EmployeeEntity;
import com.sp.user.module.employee.repository.EmployeeRepository;
import com.sp.user.spring.data.UserContextHolder;
import org.springframework.jmx.support.ObjectNameManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
@Service
public class EmployeeService extends BaseService<EmployeeEntity, EmployeeDTO, EmployeeEntity.PrimaryKey> {

    private final EmployeeRepository repository;

    public EmployeeService(ObjectMapper objectMapper, EmployeeRepository employeeRepository) {
        super(objectMapper, EmployeeDTO.class, EmployeeEntity.class, EmployeeConstants.ENTITY_NAME, employeeRepository);
        this.repository = employeeRepository;
    }

    @Override
    public EmployeeEntity.PrimaryKey getPrimaryKey(EmployeeDTO empdto) {
        return new EmployeeEntity.PrimaryKey(empdto.getEmployeeId(), empdto.getEmailId());
    }





public List<EmployeeDTO> getAllEmployee (Integer pageNumber, Integer pageSize){
        List<EmployeeEntity> entities= new ArrayList<>();
        var email= UserContextHolder.getUserEmail().toUpperCase();

        if(this.isPaginationEnabled() ){
            if(pageSize ==null || pageSize<=0){
                pageSize=this.getDefaultPageSize();
            }

            if(pageNumber==null || pageNumber<0 )
                pageNumber=0;
        }

        var pageRequest= PageRequest.of(pageNumber, pageSize);
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

}



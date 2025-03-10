package com.sp.user.module.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.controller.BaseController;
import com.sp.user.module.employee.dto.EmployeeDTO;
import com.sp.user.module.employee.entity.EmployeeEntity;
import com.sp.user.module.employee.service.EmployeeService;
import com.sp.user.shared.ListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/employee")
public class EmployeeController extends BaseController<EmployeeEntity, EmployeeEntity.PrimaryKey, EmployeeDTO> {

    private final EmployeeService empService;
    public EmployeeController(EmployeeService service, ObjectMapper objectMapper){
        super(service,objectMapper);
        empService=service;
    }

    @GetMapping("/Entities")
    public ResponseEntity<ListResponse<EmployeeDTO>> getAllEmployee(){
        var responseData = empService.getAllEmployee(0, 10);
        return ResponseEntity.ok(ListResponse.of(responseData));
    }


}

package com.sp.user.module.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.user.base.controller.BaseController;
import com.sp.user.module.employee.dto.EmployeeDTO;
import com.sp.user.module.employee.entity.EmployeeEntity;
import com.sp.user.module.employee.service.EmployeeService;
import com.sp.user.module.employee.utils.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/employee")
@CrossOrigin(origins = "*")
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

    @PostMapping("/bulk")
    public ResponseEntity<?> bulkUpload(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            Map<String, String> status= empService.bulkUpload(file);
            return EmployeeResponse.responceBuilder(CommonConstants.MASS_SAVE_OR_UPDATE_RETURN_STR  , HttpStatus.OK, status);
        }catch (Exception exp){
            return EmployeeResponse.responceBuilder(exp.getMessage(), HttpStatus.EXPECTATION_FAILED, exp);
        }

    }

    @PostMapping()
    public ResponseEntity<? extends  EmployeeDTO> createEntity(@RequestBody  EmployeeDTO dto){
           ResponseEntity responseEntity= this.service.createEntity(dto, false);
            return responseEntity;
    }

   @PatchMapping
    public ResponseEntity<?extends EmployeeDTO> updateEntity(@RequestBody EmployeeDTO dto){
       ResponseEntity responseEntity= this.service.createEntity(dto, true);
        return responseEntity;
    }



}

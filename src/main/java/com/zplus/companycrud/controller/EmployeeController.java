package com.zplus.companycrud.controller;

import com.zplus.companycrud.dto.EmployeeReqDto;
import com.zplus.companycrud.model.EmployeeModel;
import com.zplus.companycrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    private ResponseEntity insertEmployee(@RequestBody EmployeeReqDto employeeReqDto){
        Boolean flag = employeeService.insertEmployee(employeeReqDto);

        if(flag)
            return new ResponseEntity(flag, HttpStatus.OK);
        else
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping
    private ResponseEntity updateEmployee(@RequestBody EmployeeReqDto employeeReqDto){
        Boolean flag= employeeService.updateEmployee(employeeReqDto);

        if(flag)
            return  new ResponseEntity(flag,HttpStatus.OK);
        else
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @GetMapping
    private ResponseEntity getAllEmployeeDetails()
    {
        List list=employeeService.getAllEmployeeDetails();

        if(list.size()!=0)
            return new ResponseEntity(list, HttpStatus.OK);
        else
            return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @GetMapping("/getByEmployeeId/{employeeId}")
    private ResponseEntity getByEmployeeId (@PathVariable Integer employeeId)
    {
        EmployeeModel employeeModel =employeeService.getByEmployeeId(employeeId);
        if(employeeModel!=null)
            return new ResponseEntity(employeeModel, HttpStatus.OK);
        else
            return new ResponseEntity(employeeModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }





}

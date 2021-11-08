package com.zplus.companycrud.service;

import com.zplus.companycrud.dto.EmployeeReqDto;
import com.zplus.companycrud.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    Boolean insertEmployee(EmployeeReqDto employeeReqDto);

    Boolean updateEmployee(EmployeeReqDto employeeReqDto);

    List getAllEmployeeDetails();

    EmployeeModel getByEmployeeId(Integer employeeId);



}


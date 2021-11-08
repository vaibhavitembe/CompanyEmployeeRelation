package com.zplus.companycrud.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter

public class EmployeeReqDto {
    private Integer employeeId;
    private String employeeName;
    private String mobileNo;
    private String address;
    private String emailId;
    private Integer companyId;


}

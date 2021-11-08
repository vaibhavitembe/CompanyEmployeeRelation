package com.zplus.companycrud.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompanyReqDto {
    private Integer companyId;
    private String companyName;
    private String emailId;
    private String address;
    private String description;
    private String status;
    private Double walletPoint;

//    List<EmployeeReqDto> employeeReqDtoList=new ArrayList<>();
}

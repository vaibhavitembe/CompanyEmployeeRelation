package com.zplus.companycrud.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentDetailsResDto {

    private Integer studentId;

    private String studentName;

    private String address;

    private String status;

    private List subList= new ArrayList<>();

}

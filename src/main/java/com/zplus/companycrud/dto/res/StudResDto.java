package com.zplus.companycrud.dto.res;

import com.zplus.companycrud.model.SubjectModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudResDto {

    private Integer studentId;

    private String studentName;

    private String mobileNo;

    private String address;

    private String status;

    private List SubjectList=new ArrayList<>();




}

package com.zplus.companycrud.dto;

import com.zplus.companycrud.model.StudentModel;

import com.zplus.companycrud.model.SubjectModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentReqDto {

    private Integer studentId;
    private String studentName;
    private String mobileNo;
    private String address;
    private String status;

    List<Integer> subjectIdList= new ArrayList<>();

    List<StudentModel> studentList= new ArrayList<>();


}

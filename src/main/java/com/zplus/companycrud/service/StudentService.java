package com.zplus.companycrud.service;

import com.zplus.companycrud.dto.StudentReqDto;
import com.zplus.companycrud.dto.res.StudResDto;

import java.util.List;

public interface StudentService {
    Boolean insertStudentMaster(StudentReqDto studentReqDto);

    Boolean updateStudentMaster(StudentReqDto studentReqDto);

    List getAllStudentDetails();

    StudResDto getByStudentId(Integer studentId);


    List activeStudentDetails();
}







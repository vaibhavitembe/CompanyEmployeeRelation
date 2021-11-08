package com.zplus.companycrud.service;

import com.zplus.companycrud.dto.SubjectReqDto;
import com.zplus.companycrud.dto.res.SubjectResDto;
import com.zplus.companycrud.model.SubjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SubjectService  {
    Boolean insertSubjectMaster(SubjectReqDto subjectReqDto);

    Boolean updateSubjectMaster(SubjectReqDto subjectReqDto);

    List getAllSubjectDetails();


    SubjectResDto getBySubjectId(Integer subjectId);
}






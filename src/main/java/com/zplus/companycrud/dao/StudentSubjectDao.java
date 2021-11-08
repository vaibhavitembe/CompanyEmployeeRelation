package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.StudentModel;
import com.zplus.companycrud.model.StudentSubjectModel;
import com.zplus.companycrud.model.SubjectModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentSubjectDao extends CrudRepository<StudentSubjectModel,Integer> {

    @Transactional
    @Modifying
    @Query("delete from StudentSubjectModel as sm where sm.studentModel.studentId =:studentId")
    Integer deleteByStudentId(@Param("studentId") Integer studentId);

    List<StudentSubjectModel> findAllByStudentModel(StudentModel studentModel);


    @Transactional
    @Modifying
    @Query("delete from StudentSubjectModel as sm where sm.subjectModel.subjectId =:subjectId")
    Integer deleteBySubjectId(@Param("subjectId") Integer subjectId);

    List<StudentSubjectModel> findAllBySubjectModel(SubjectModel subjectModel);
}





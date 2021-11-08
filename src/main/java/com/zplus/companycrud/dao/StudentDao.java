package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.StudentModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<StudentModel,Integer> {


    List<StudentModel> findAllByStatus(String pending);
}



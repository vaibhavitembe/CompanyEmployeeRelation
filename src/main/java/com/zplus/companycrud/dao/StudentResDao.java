package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResDao extends CrudRepository<StudentModel,Integer> {
}

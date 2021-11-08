package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.EmployeeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

}

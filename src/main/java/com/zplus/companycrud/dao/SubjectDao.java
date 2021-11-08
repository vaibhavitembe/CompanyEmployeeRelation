package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.SubjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends CrudRepository<SubjectModel,Integer> {

}

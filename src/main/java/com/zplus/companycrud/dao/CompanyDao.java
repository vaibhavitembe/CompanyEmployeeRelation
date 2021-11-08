package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.CompanyModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface CompanyDao extends CrudRepository<CompanyModel,Integer> {


    List findByStatus(String active);
}


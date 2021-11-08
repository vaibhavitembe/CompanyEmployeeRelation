package com.zplus.companycrud.service;

import com.zplus.companycrud.dto.CompanyReqDto;
import com.zplus.companycrud.model.CompanyModel;

import java.util.List;

public interface CompanyService {
    Boolean insertCompany(CompanyReqDto companyReqDto);

    Boolean updateCompany(CompanyReqDto companyReqDto);

    List getAllCompanyDetails();

    CompanyModel getCompanyDetailsByCompanyId(Integer companyId);

    List activeCompanyDetails();
}

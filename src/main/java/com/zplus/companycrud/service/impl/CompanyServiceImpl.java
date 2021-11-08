package com.zplus.companycrud.service.impl;

import com.zplus.companycrud.dao.CompanyDao;
import com.zplus.companycrud.dto.CompanyReqDto;
import com.zplus.companycrud.model.CompanyModel;
import com.zplus.companycrud.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public Boolean insertCompany(CompanyReqDto companyReqDto) {
        CompanyModel companyModel=new CompanyModel();


        companyModel.setCompanyName(companyReqDto.getCompanyName());
        companyModel.setAddress(companyReqDto.getAddress());
        companyModel.setEmailId(companyReqDto.getEmailId());
        companyModel.setDescription(companyReqDto.getDescription());
        companyModel.setWalletPoint(companyReqDto.getWalletPoint());
        companyModel.setStatus(companyReqDto.getStatus());
        try {
            companyDao.save(companyModel);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public Boolean updateCompany(CompanyReqDto companyReqDto) {

        CompanyModel companyModel = new CompanyModel();

        companyModel.setCompanyId(companyReqDto.getCompanyId());
        companyModel.setCompanyName(companyReqDto.getCompanyName());
        companyModel.setAddress(companyReqDto.getAddress());
        companyModel.setEmailId(companyReqDto.getEmailId());
        companyModel.setDescription(companyReqDto.getDescription());
        companyModel.setWalletPoint(companyReqDto.getWalletPoint());
//        companyModel.setStatus("Active");
        try {

            companyDao.save(companyModel);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllCompanyDetails() {
        return (List) companyDao.findAll();
    }

    @Override
    public CompanyModel getCompanyDetailsByCompanyId(Integer companyId) {
    CompanyModel companyModel = new CompanyModel();

    try{
        companyModel=companyDao.findOne(companyId);
        return companyModel;
    }catch (Exception e){
        e.printStackTrace();
        return companyModel;
    }
    }

    @Override
    public List activeCompanyDetails() {
        return  companyDao.findByStatus("Active");
    }
}







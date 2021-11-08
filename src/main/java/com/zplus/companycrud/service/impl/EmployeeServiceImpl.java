package com.zplus.companycrud.service.impl;

import com.zplus.companycrud.dao.EmployeeDao;
import com.zplus.companycrud.dto.CompanyReqDto;
import com.zplus.companycrud.dto.EmployeeReqDto;
import com.zplus.companycrud.model.CompanyModel;
import com.zplus.companycrud.model.EmployeeModel;
import com.zplus.companycrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Boolean insertEmployee(EmployeeReqDto employeeReqDto) {
        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setEmployeeName(employeeReqDto.getEmployeeName());
        employeeModel.setAddress(employeeReqDto.getAddress());
        employeeModel.setEmailId(employeeReqDto.getEmailId());
        employeeModel.setMobileNo(employeeReqDto.getMobileNo());
        try{
            CompanyModel companyModel = new CompanyModel();
            companyModel.setCompanyId(employeeReqDto.getCompanyId());

            employeeModel.setCompanyModel(companyModel);
            employeeDao.save(employeeModel);
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public Boolean updateEmployee(EmployeeReqDto employeeReqDto) {
        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setEmployeeId(employeeReqDto.getEmployeeId());
        employeeModel.setEmployeeName(employeeReqDto.getEmployeeName());
        employeeModel.setAddress(employeeReqDto.getAddress());
        employeeModel.setEmailId(employeeReqDto.getEmailId());
        employeeModel.setMobileNo(employeeReqDto.getMobileNo());
        try {
            CompanyModel companyModel = new CompanyModel();
            companyModel.setCompanyId(employeeReqDto.getCompanyId());

            employeeModel.setCompanyModel(companyModel);
            employeeDao.save(employeeModel);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllEmployeeDetails() {
        return (List) employeeDao.findAll();
    }

    @Override
    public EmployeeModel getByEmployeeId(Integer employeeId) {
        EmployeeModel employeeModel = new EmployeeModel();
        try {
            employeeModel = employeeDao.findOne(employeeId);
            return employeeModel;
        } catch (Exception e) {
            e.printStackTrace();
            return employeeModel;
        }

    }

}

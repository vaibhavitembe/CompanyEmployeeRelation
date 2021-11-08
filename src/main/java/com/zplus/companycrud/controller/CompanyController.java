package com.zplus.companycrud.controller;


import com.zplus.companycrud.dto.CompanyReqDto;
import com.zplus.companycrud.model.CompanyModel;
import com.zplus.companycrud.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.BooleanControl;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    private ResponseEntity insertCompany(@RequestBody CompanyReqDto companyReqDto) {
        Boolean flag = companyService.insertCompany(companyReqDto);

        if (flag)
            return new ResponseEntity(flag, HttpStatus.OK);
        else
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    private ResponseEntity updateCompany(@RequestBody CompanyReqDto companyReqDto) {
        Boolean flag = companyService.updateCompany(companyReqDto);

        if (flag)
            return new ResponseEntity(flag, HttpStatus.OK);
        else
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping
    private ResponseEntity getAllCompanyDetails() {
        List list = companyService.getAllCompanyDetails();

        if (list.size() != 0)
            return new ResponseEntity(list, HttpStatus.OK);
        else
            return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getCompanyDetailsByCompanyId/{companyId}")
    private ResponseEntity getCompanyDetailsByCompanyId(@PathVariable Integer companyId) {
        CompanyModel companyModel = companyService.getCompanyDetailsByCompanyId(companyId);

        if (companyModel != null)
            return new ResponseEntity(companyModel, HttpStatus.OK);
        else
            return new ResponseEntity(companyModel, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @GetMapping(value = "activeCompanyDetails")
    private ResponseEntity activeCompanyDetails(){
        List list = companyService.activeCompanyDetails();

        return new ResponseEntity(list,HttpStatus.OK);
    }
}

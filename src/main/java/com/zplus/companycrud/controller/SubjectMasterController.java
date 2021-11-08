package com.zplus.companycrud.controller;

import com.zplus.companycrud.dto.SubjectReqDto;
import com.zplus.companycrud.dto.res.StudResDto;
import com.zplus.companycrud.dto.res.SubjectResDto;
import com.zplus.companycrud.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "subject_master")
public class SubjectMasterController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    private ResponseEntity insertSubjectMaster(@RequestBody SubjectReqDto subjectReqDto){
        Boolean flag = subjectService.insertSubjectMaster(subjectReqDto);

        if(flag)
            return new ResponseEntity(flag, HttpStatus.OK);
        else
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping
    private ResponseEntity updateSubjectMaster(@RequestBody SubjectReqDto subjectReqDto){
        Boolean flag = subjectService.updateSubjectMaster(subjectReqDto);

        if(flag)
            return new ResponseEntity(flag,HttpStatus.OK);
        else
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping
    private ResponseEntity getAllSubjectDetails(){
        List list = subjectService.getAllSubjectDetails();

        if(list.size() !=0)
            return new ResponseEntity(list,HttpStatus.OK);
        else
            return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/getBySubjectId/{subjectId}")
    private ResponseEntity getBySubjectId(@PathVariable Integer subjectId){
        SubjectResDto subjectResDto = subjectService.getBySubjectId(subjectId);
         return new ResponseEntity(subjectResDto,HttpStatus.OK);

        }
    }









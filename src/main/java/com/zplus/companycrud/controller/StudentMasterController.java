package com.zplus.companycrud.controller;


import com.zplus.companycrud.dto.StudentReqDto;
import com.zplus.companycrud.dto.res.OrderResDto;
import com.zplus.companycrud.dto.res.StudResDto;
import com.zplus.companycrud.model.StudentModel;
import com.zplus.companycrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "student_master")
public class StudentMasterController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    private ResponseEntity insertStudentMaster(@RequestBody StudentReqDto studentReqDto) {
        Boolean flag = studentService.insertStudentMaster(studentReqDto);

        if (flag)
            return new ResponseEntity(flag, HttpStatus.OK);
        else
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping
    private ResponseEntity updateStudentMaster(@RequestBody StudentReqDto studentReqDto){
        Boolean flag = studentService.updateStudentMaster(studentReqDto);

        if(flag)
            return new ResponseEntity(flag,HttpStatus.OK);
        else
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping
    private ResponseEntity getAllStudentDetails(){
        List list = studentService.getAllStudentDetails();

        if(list.size()!=0)
            return new ResponseEntity(list,HttpStatus.OK);
        else
            return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping(value = "/getByStudentId/{studentId}")
    private ResponseEntity getByStudentId(@PathVariable Integer studentId){

        StudResDto studentModel =studentService.getByStudentId(studentId);

        return new ResponseEntity(studentModel,HttpStatus.OK);

    }
    @GetMapping(value = "activeStudentDetails")
    private ResponseEntity activeStudentDetails(){
        List list = studentService.activeStudentDetails();

        return new ResponseEntity(list,HttpStatus.OK);
    }

}



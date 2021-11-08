package com.zplus.companycrud.service.impl;

import com.zplus.companycrud.dao.StudentSubjectDao;
import com.zplus.companycrud.dao.SubjectDao;
import com.zplus.companycrud.dto.SubjectReqDto;
import com.zplus.companycrud.dto.res.StudentDetailsResDto;
import com.zplus.companycrud.dto.res.SubjectDetailsResDto;
import com.zplus.companycrud.dto.res.SubjectResDto;
import com.zplus.companycrud.model.CompanyModel;
import com.zplus.companycrud.model.StudentModel;
import com.zplus.companycrud.model.StudentSubjectModel;
import com.zplus.companycrud.model.SubjectModel;
import com.zplus.companycrud.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private StudentSubjectDao studentSubjectDao;

    @Override
    public Boolean insertSubjectMaster(SubjectReqDto subjectReqDto) {

        Boolean flag;
        SubjectModel subjectModel = new SubjectModel();

        subjectModel.setSubjectName(subjectReqDto.getSubjectName());
        subjectModel.setMarks(subjectReqDto.getMarks());

        try {

            subjectDao.save(subjectModel);
            flag= true;
        }catch (Exception e){
            e.printStackTrace();
            flag= false;
        }
        if(flag)
        {
            for(Integer studentId : subjectReqDto.getStudentIdList())
            {
                StudentSubjectModel studentSubjectModel =new StudentSubjectModel();
                StudentModel studentModel=new StudentModel();

                studentModel.setStudentId(studentId);

                studentSubjectModel.setStudentModel(studentModel);
                studentSubjectModel.setSubjectModel(subjectModel);

                try {
                    studentSubjectDao.save(studentSubjectModel);
                    flag = true;

                } catch (Exception e) {
                    flag = false;
                }
            }
        }return flag;
    }

    @Override
    public Boolean updateSubjectMaster(SubjectReqDto subjectReqDto) {
        Boolean flag;
        SubjectModel subjectModel = new SubjectModel();

        subjectModel.setSubjectId(subjectReqDto.getSubjectId());
        subjectModel.setSubjectName(subjectReqDto.getSubjectName());
        subjectModel.setMarks(subjectReqDto.getMarks());

        try {

            subjectDao.save(subjectModel);
            flag= true;
        }catch (Exception e){
            e.printStackTrace();
            flag= false;
        }
        if(flag)
        {
            Integer subjectId = studentSubjectDao.deleteBySubjectId(subjectReqDto.getSubjectId());
            if (subjectId != 0) {
                for (Integer studentId : subjectReqDto.getStudentIdList()) {
                    StudentSubjectModel studentSubjectModel = new StudentSubjectModel();
                    StudentModel studentModel = new StudentModel();

                    studentModel.setStudentId(studentId);

                    studentSubjectModel.setSubjectModel(subjectModel);
                    studentSubjectModel.setStudentModel(studentModel);

                    try {
                        studentSubjectDao.save(studentSubjectModel);
                        flag = true;

                    } catch (Exception e) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
        }

    @Override
    public List getAllSubjectDetails() {
        List alllist = new ArrayList();
        SubjectDetailsResDto subjectDetailsResDto = new SubjectDetailsResDto();

        List<SubjectModel> subjectModelList = (List<SubjectModel>) subjectDao.findAll();
        for (SubjectModel subjectModel : subjectModelList) {
            subjectDetailsResDto.setSubjectId(subjectModel.getSubjectId());
            subjectDetailsResDto.setSubjectName(subjectModel.getSubjectName());
            subjectDetailsResDto.setMarks(subjectModel.getMarks());

            List<StudentSubjectModel> studentSubjectModelList = studentSubjectDao.findAllBySubjectModel(subjectModel);

            for (StudentSubjectModel studentSubjectModel : studentSubjectModelList) {
                studentSubjectModel.setStudentId(studentSubjectModel.getStudentModel().getStudentId());
                studentSubjectModel.setStudentName(studentSubjectModel.getStudentModel().getStudentName());
                studentSubjectModel.setMobileNo(studentSubjectModel.getStudentModel().getMobileNo());
                studentSubjectModel.setAddress(studentSubjectModel.getAddress());
            }
            subjectDetailsResDto.setStudList(studentSubjectModelList);
            alllist.add(subjectDetailsResDto);
        }
        return alllist;
    }

    @Override
    public SubjectResDto getBySubjectId(Integer subjectId) {
        SubjectResDto subjectResDto = new SubjectResDto();

        SubjectModel subjectModel = subjectDao.findOne(subjectId);

        subjectResDto.setSubjectId(subjectModel.getSubjectId());
        subjectResDto.setSubjectName(subjectModel.getSubjectName());
        subjectResDto.setMarks(subjectModel.getMarks());

        List<StudentSubjectModel> studentSubjectModelList=studentSubjectDao.findAllBySubjectModel(subjectModel);
        for(StudentSubjectModel studentSubjectModel : studentSubjectModelList)
        {
            studentSubjectModel.setStudentId(studentSubjectModel.getStudentModel().getStudentId());
            studentSubjectModel.setStudentName(studentSubjectModel.getStudentModel().getStudentName());
            studentSubjectModel.setMobileNo(studentSubjectModel.getStudentModel().getMobileNo());
            studentSubjectModel.setAddress(studentSubjectModel.getStudentModel().getAddress());
        }
        subjectResDto.setStudentList(studentSubjectModelList);
        return  subjectResDto;
    }
}









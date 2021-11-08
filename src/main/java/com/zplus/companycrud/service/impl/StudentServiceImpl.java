package com.zplus.companycrud.service.impl;

import com.zplus.companycrud.dao.StudentDao;
import com.zplus.companycrud.dao.StudentSubjectDao;
import com.zplus.companycrud.dto.StudentReqDto;
import com.zplus.companycrud.dto.res.OrderResDto;
import com.zplus.companycrud.dto.res.StudResDto;
import com.zplus.companycrud.dto.res.StudentDetailsResDto;
import com.zplus.companycrud.model.OrderModel;
import com.zplus.companycrud.model.StudentModel;
import com.zplus.companycrud.model.StudentSubjectModel;
import com.zplus.companycrud.model.SubjectModel;
import com.zplus.companycrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentSubjectDao studentSubjectDao;


    @Override
    public Boolean insertStudentMaster(StudentReqDto studentReqDto) {
        Boolean flag;
        StudentModel studentModel = new StudentModel();

        studentModel.setStudentName(studentReqDto.getStudentName());
        studentModel.setMobileNo(studentReqDto.getMobileNo());
        studentModel.setAddress(studentReqDto.getAddress());
        studentModel.setStatus(studentReqDto.getStatus());

        try {

            studentDao.save(studentModel);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        if (flag) {
            for (Integer subjectId : studentReqDto.getSubjectIdList()) {
                StudentSubjectModel studentSubjectModel = new StudentSubjectModel();
                SubjectModel subjectModel = new SubjectModel();

                subjectModel.setSubjectId(subjectId);

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
        return flag;
    }

    @Override
    public Boolean updateStudentMaster(StudentReqDto studentReqDto) {
        Boolean flag;
        StudentModel studentModel = new StudentModel();

        studentModel.setStudentId(studentReqDto.getStudentId());
        studentModel.setStudentName(studentReqDto.getStudentName());
        studentModel.setMobileNo(studentReqDto.getMobileNo());
        studentModel.setAddress(studentModel.getAddress());
        studentModel.setStatus(studentModel.getStatus());

        try {
            studentDao.save(studentModel);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        if (flag) {
            Integer studentId = studentSubjectDao.deleteByStudentId(studentReqDto.getStudentId());
            if (studentId != 0) {
                for (Integer subjectId : studentReqDto.getSubjectIdList()) {
                    StudentSubjectModel studentSubjectModel = new StudentSubjectModel();
                    SubjectModel subjectModel = new SubjectModel();

                    subjectModel.setSubjectId(subjectId);

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
    public List getAllStudentDetails() {
        List alllist = new ArrayList();
        StudentDetailsResDto studentDetailsResDto = new StudentDetailsResDto();

        List<StudentModel> studentModelList = (List<StudentModel>) studentDao.findAll();
        for (StudentModel studentModel : studentModelList) {
            studentDetailsResDto.setStudentId(studentModel.getStudentId());
            studentDetailsResDto.setStudentName(studentModel.getStudentName());
            studentDetailsResDto.setAddress(studentModel.getAddress());
            studentDetailsResDto.setStatus(studentModel.getStatus());


            List<StudentSubjectModel> studentSubjectModelList = studentSubjectDao.findAllByStudentModel(studentModel);

            for (StudentSubjectModel studentSubjectModel : studentSubjectModelList) {
                studentSubjectModel.setSubjectId(studentSubjectModel.getSubjectModel().getSubjectId());
                studentSubjectModel.setSubjectName(studentSubjectModel.getSubjectModel().getSubjectName());
            }
            studentDetailsResDto.setSubList(studentSubjectModelList);
            alllist.add(studentDetailsResDto);
        }
        return alllist;
    }

    @Override
    public StudResDto getByStudentId(Integer studentId) {
//        List alllist = new ArrayList();
        StudResDto studResDto = new StudResDto();
        StudentModel studentModel = studentDao.findOne(studentId);

        studResDto.setStudentId(studentModel.getStudentId());
        studResDto.setStudentName(studentModel.getStudentName());
        studResDto.setMobileNo(studentModel.getMobileNo());
        studResDto.setAddress(studentModel.getAddress());
        studResDto.setStatus(studentModel.getStatus());

        List<StudentSubjectModel> studentSubjectModelList = studentSubjectDao.findAllByStudentModel(studentModel);
        for (StudentSubjectModel studentSubjectModel : studentSubjectModelList) {
            studentSubjectModel.setSubjectId(studentSubjectModel.getSubjectModel().getSubjectId());
            studentSubjectModel.setSubjectName(studentSubjectModel.getSubjectModel().getSubjectName());

        }
        studResDto.setSubjectList(studentSubjectModelList);
        return studResDto;
    }

    @Override
    public List activeStudentDetails() {

        List alllist = new ArrayList();
        StudResDto studResDto = new StudResDto();

        List<StudentModel> studentModelList = (List<StudentModel>) studentDao.findAllByStatus("Active");
        for (StudentModel studentModel : studentModelList) {
            studResDto.setStudentId(studentModel.getStudentId());
            studResDto.setStudentName(studentModel.getStudentName());
            studResDto.setAddress(studentModel.getAddress());
            studResDto.setStatus(studentModel.getStatus());


            List<StudentSubjectModel> studentSubjectModelList = studentSubjectDao.findAllByStudentModel(studentModel);

            for (StudentSubjectModel studentSubjectModel : studentSubjectModelList) {
                studentSubjectModel.setSubjectId(studentSubjectModel.getSubjectModel().getSubjectId());
                studentSubjectModel.setSubjectName(studentSubjectModel.getSubjectModel().getSubjectName());
            }
            studResDto.setSubjectList(studentSubjectModelList);
            alllist.add(studResDto);
        }
        return alllist;
    }
}





















//        List alllist=new ArrayList();
//        StudResDto studResDto = new StudResDto();
//        List<StudentModel> list =new ArrayList<>();
//        list=studentDao.findAllByStatus("Active");
//
//        for(StudentModel studentModel :list){
//            studResDto.setStudentId(studentModel.getStudentId());
//            studResDto.setStudentName(studentModel.getStudentName());
//            studResDto.setMobileNo(studentModel.getMobileNo());
//            studResDto.setAddress(studentModel.getAddress());
//
//            List<StudentSubjectModel> studentSubjectModelList = studentSubjectDao.findAllByStudentModel(studentModel);
//
//            for (StudentSubjectModel studentSubjectModel : studentSubjectModelList) {
//                studentSubjectModel.setSubjectId(studentSubjectModel.getSubjectModel().getSubjectId());
//                studentSubjectModel.setSubjectName(studentSubjectModel.getSubjectModel().getSubjectName());
//            }
//
//         List list1 = studentSubjectDao.findAllByStudentModel(studentModel);
//            studResDto.setSubjectList(list);
//        }return alllist;
//
//    }

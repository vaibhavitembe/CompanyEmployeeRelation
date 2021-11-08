package com.zplus.companycrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "student_subject")
public class StudentSubjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer studentSubjectId;


    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="studentId")
    @JsonIgnore
    private StudentModel studentModel;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subjectId")
    @JsonIgnore
    private SubjectModel subjectModel;

    @Transient
    private Integer subjectId;
    @Transient
    private String subjectName;

    @Transient
    private Integer studentId;
    @Transient
    private String studentName;
    @Transient
    private String mobileNo;
    @Transient
    private String address;

}

package com.zplus.companycrud.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "student_master")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer studentId;

    @Column
    private String studentName;

    @Column
    private String mobileNo;

    @Column
    private String address;

    @Column
    private String status;
}

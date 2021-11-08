package com.zplus.companycrud.model;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "subject_master")
public class SubjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer subjectId;

    @Column
    private String subjectName;

    @Column
    private Double marks;
}

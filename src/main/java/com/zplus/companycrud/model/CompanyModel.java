package com.zplus.companycrud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name= "company")
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer companyId;

    @Column
    private String companyName;

    @Column
    private String emailId;

    @Column
    private String address;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private Double walletPoint;

}

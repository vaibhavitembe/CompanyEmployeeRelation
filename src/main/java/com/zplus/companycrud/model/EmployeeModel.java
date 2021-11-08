package com.zplus.companycrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name= "employee")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer employeeId;

    @Column
    private String employeeName;

    @Column
    private String mobileNo;

    @Column
    private String address;

    @Column
    private String emailId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private CompanyModel companyModel;








}

package com.zplus.companycrud.model;


import com.zplus.companycrud.dto.OrderHistoryReqDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "order_master")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer orderId;

    @Column
    private Integer orderNo;

   @Temporal(TemporalType.DATE)
    private Date todayDate;

   @Column
    private Double orderAmt;

   @Column
    private String orderStatus;


}

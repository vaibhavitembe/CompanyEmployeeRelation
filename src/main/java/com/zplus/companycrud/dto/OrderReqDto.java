package com.zplus.companycrud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderReqDto {

    private Integer orderId;
    private Integer orderNo;
    private Date todayDate;
    private Double orderAmt;
    private String orderStatus;

    List<OrderHistoryReqDto> orderHistoryReqDtoList=new ArrayList<>();

}

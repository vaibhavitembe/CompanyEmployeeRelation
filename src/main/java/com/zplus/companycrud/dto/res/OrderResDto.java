package com.zplus.companycrud.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderResDto {

    private Integer orderId;
    private Integer orderNo;
    private Date todayDate;
    private Double orderAmt;
    private String orderStatus;

    private List orderHistoryList=new ArrayList<>();
}

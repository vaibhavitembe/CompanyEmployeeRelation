package com.zplus.companycrud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderHistoryReqDto {

    private Integer orderHistoryId;
    private String productName;
    private Double productAmt;
    private Double productQuantity;
    private Integer orderId;


}

package com.zplus.companycrud.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderHistoryResDto {

    private Integer orderHistoryId;
    private String productName;
    private Double productAmt;
    private Double productQuantity;

}

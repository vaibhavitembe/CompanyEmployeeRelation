package com.zplus.companycrud.service;

import com.zplus.companycrud.dto.OrderReqDto;
import com.zplus.companycrud.dto.res.OrderResDto;

import java.util.List;

public interface OrderService {

    Boolean insertOrder(OrderReqDto orderReqDto);

    Boolean updateOrder(OrderReqDto orderReqDto);

    List getAllOrderDetails();


    OrderResDto getByOrderId(Integer orderId);

    List activeOrderDetails();


//    List activeOrderDetails();
}







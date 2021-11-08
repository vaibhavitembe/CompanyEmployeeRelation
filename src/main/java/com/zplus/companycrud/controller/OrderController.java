package com.zplus.companycrud.controller;


import com.zplus.companycrud.dto.OrderReqDto;
import com.zplus.companycrud.dto.res.OrderHistoryResDto;
import com.zplus.companycrud.dto.res.OrderResDto;
import com.zplus.companycrud.model.EmployeeModel;
import com.zplus.companycrud.model.OrderModel;
import com.zplus.companycrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "order_master")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    private ResponseEntity insertOrder(@RequestBody OrderReqDto orderReqDto) {
        Boolean flag = orderService.insertOrder(orderReqDto);

        if (flag)
            return new ResponseEntity(flag, HttpStatus.OK);
        else
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    private ResponseEntity updateOrder(@RequestBody OrderReqDto orderReqDto) {
        Boolean flag = orderService.updateOrder(orderReqDto);

        if (flag)
            return new ResponseEntity(flag, HttpStatus.OK);
        else
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    private ResponseEntity getAllOrderDetails() {
        List orderHistoryResDto = orderService.getAllOrderDetails();

        if (orderHistoryResDto.size() != 0)
            return new ResponseEntity(orderHistoryResDto, HttpStatus.OK);
        else
            return new ResponseEntity(orderHistoryResDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/getByOrderId/{orderId}")
    private ResponseEntity getByOrderId(@PathVariable Integer orderId){
        OrderResDto orderModel= orderService.getByOrderId(orderId);

        if(orderModel!=null)
            return new ResponseEntity(orderModel,HttpStatus.OK);
        else
            return new ResponseEntity(orderModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @GetMapping(value = "activeOrderDetails")
    private ResponseEntity activeOrderDetails(){
      List list =orderService.activeOrderDetails();

        return new ResponseEntity(list,HttpStatus.OK);
    }



}

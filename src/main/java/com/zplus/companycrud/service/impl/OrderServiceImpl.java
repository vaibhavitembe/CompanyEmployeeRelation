package com.zplus.companycrud.service.impl;

import com.zplus.companycrud.dao.OrderDao;
import com.zplus.companycrud.dao.OrderHistoryDao;
import com.zplus.companycrud.dto.OrderHistoryReqDto;
import com.zplus.companycrud.dto.OrderReqDto;
import com.zplus.companycrud.dto.res.OrderResDto;
import com.zplus.companycrud.model.OrderHistoryModel;
import com.zplus.companycrud.model.OrderModel;
import com.zplus.companycrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderHistoryDao orderHistoryDao;

    @Override
    public Boolean insertOrder(OrderReqDto orderReqDto) {
        Boolean flag;
        OrderModel orderModel = new OrderModel();

        orderModel.setOrderNo(orderReqDto.getOrderNo());
        orderModel.setOrderAmt(orderReqDto.getOrderAmt());
        orderModel.setTodayDate(new Date());
        orderModel.setOrderStatus(orderReqDto.getOrderStatus());
        try {
            orderDao.save(orderModel);
            flag = true;

        } catch (Exception e) {
            flag = false;

        }
        if (flag) {
            for (OrderHistoryReqDto orderHistoryReqDto : orderReqDto.getOrderHistoryReqDtoList()) {
                OrderHistoryModel orderHistoryModel = new OrderHistoryModel();

                orderHistoryModel.setProductName(orderHistoryReqDto.getProductName());
                orderHistoryModel.setProductAmt(orderHistoryReqDto.getProductAmt());
                orderHistoryModel.setProductQuantity(orderHistoryReqDto.getProductQuantity());

                orderHistoryModel.setOrderModel(orderModel);

                try {

                    orderHistoryDao.save(orderHistoryModel);
                    flag = true;
                } catch (Exception e) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Override
    public Boolean updateOrder(OrderReqDto orderReqDto) {
        Boolean flag;
        OrderModel orderModel = new OrderModel();

        orderModel.setOrderId(orderReqDto.getOrderId());
        orderModel.setOrderNo(orderReqDto.getOrderNo());
        orderModel.setOrderAmt(orderReqDto.getOrderAmt());
        orderModel.setOrderStatus(orderModel.getOrderStatus());
        orderModel.setTodayDate(new Date());
        try {
            orderDao.save(orderModel);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        if (flag) {
            for (OrderHistoryReqDto orderHistoryReqDto : orderReqDto.getOrderHistoryReqDtoList()) {
                OrderHistoryModel orderHistoryModel = new OrderHistoryModel();

                orderHistoryModel.setOrderHistoryId(orderHistoryReqDto.getOrderHistoryId());
                orderHistoryModel.setProductName(orderHistoryReqDto.getProductName());
                orderHistoryModel.setProductAmt(orderHistoryReqDto.getProductAmt());
                orderHistoryModel.setProductQuantity(orderHistoryReqDto.getProductQuantity());

                orderHistoryModel.setOrderModel(orderModel);

                try {

                    orderHistoryDao.save(orderHistoryModel);
                    flag = true;
                } catch (Exception e) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Override
    public List getAllOrderDetails() {
        List alllist = new ArrayList();

        OrderResDto orderResDto = new OrderResDto();
        List<OrderModel> list = (List) orderDao.findAll();
        for (OrderModel orderModel : list) {
            orderResDto.setOrderId(orderModel.getOrderId());
            orderResDto.setOrderNo(orderModel.getOrderNo());
            orderResDto.setTodayDate(orderModel.getTodayDate());
            orderResDto.setOrderAmt(orderModel.getOrderAmt());
            orderModel.setOrderStatus(orderModel.getOrderStatus());

            List list1 = orderHistoryDao.findAllByOrderModel(orderModel);
            orderResDto.setOrderHistoryList(list1);

            alllist.add(orderResDto);

        }
        return alllist;

    }

    @Override
    public OrderResDto getByOrderId(Integer orderId) {
        List alllist = new ArrayList();
        OrderResDto orderResDto = new OrderResDto();
        OrderModel orderModel = orderDao.findOne(orderId);

        orderResDto.setOrderId(orderModel.getOrderId());
        orderResDto.setOrderNo(orderModel.getOrderNo());
        orderResDto.setTodayDate(orderModel.getTodayDate());
        orderResDto.setOrderAmt(orderModel.getOrderAmt());
        orderResDto.setOrderStatus(orderModel.getOrderStatus());

        List list1 = orderHistoryDao.findAllByOrderModel(orderModel);
        orderResDto.setOrderHistoryList(list1);

        return orderResDto;

    }

    @Override
    public List activeOrderDetails() {
        List alllist = new ArrayList();
        OrderResDto orderResDto = new OrderResDto();
        List<OrderModel> list = new ArrayList<>();
        list = (List<OrderModel>) orderDao.findAllByOrderStatus("Pending");
        for (OrderModel orderModel : list) {
            orderResDto.setOrderId(orderModel.getOrderId());
            orderResDto.setOrderNo(orderModel.getOrderNo());
            orderResDto.setTodayDate(orderModel.getTodayDate());
            orderResDto.setOrderAmt(orderModel.getOrderAmt());
            orderResDto.setOrderStatus(orderModel.getOrderStatus());

            List list1 = orderHistoryDao.findAllByOrderModel(orderModel);
            orderResDto.setOrderHistoryList(list1);

            alllist.add(orderResDto);
        }
        return alllist;
    }
}













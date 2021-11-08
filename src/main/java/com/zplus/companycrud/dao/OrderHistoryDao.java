package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.OrderHistoryModel;
import com.zplus.companycrud.model.OrderModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryDao extends CrudRepository<OrderHistoryModel,Integer> {
    List findAllByOrderModel(OrderModel orderModel);


//    List findAllByOrderModel(OrderModel orderModel);
}


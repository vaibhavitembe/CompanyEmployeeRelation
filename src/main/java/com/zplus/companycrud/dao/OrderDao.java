package com.zplus.companycrud.dao;

import com.zplus.companycrud.model.OrderModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OrderDao extends CrudRepository<OrderModel,Integer> {
    List findAllByOrderStatus(String pending);


//    List findAllByOrderStatus();
}



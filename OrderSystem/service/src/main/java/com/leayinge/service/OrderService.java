package com.leayinge.service;

import com.leayinge.domain.Order;

import java.util.List;

public interface OrderService {

    Order findById(Integer orderId) throws Exception;

    List<Order> findAll(int page, int size) throws Exception; //分页要在这里给参数

}

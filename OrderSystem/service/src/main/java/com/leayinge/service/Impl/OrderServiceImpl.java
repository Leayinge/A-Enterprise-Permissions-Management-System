package com.leayinge.service.Impl;

import com.github.pagehelper.PageHelper;
import com.leayinge.dao.OrderDao;
import com.leayinge.domain.Order;
import com.leayinge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public Order findById(Integer orderId) throws Exception {
        return orderDao.findById(orderId);
    }

    @Override
    public List<Order> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size); //pageNum是页码，pageSize是每页数量,必须和return邻接，不然失效
        return orderDao.findAll();
    }
}

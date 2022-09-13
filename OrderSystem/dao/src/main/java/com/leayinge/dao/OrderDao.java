package com.leayinge.dao;

import com.leayinge.domain.Member;
import com.leayinge.domain.Order;
import com.leayinge.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {

    @Select("select * from `order`")
    public List<Order> findAll() throws Exception; //分页不影响这个

    @Select("select * from `order` where `order_id`=#{orderId}")
    @Results({
            @Result(id = true, property = "orderId", column = "order_id"),
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "orderTime", column = "order_time"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "peopleCount", column = "people_count"),
            @Result(property = "payType", column = "pay_type"),
            @Result(property = "orderDesc", column = "order_desc"),
            @Result(property = "product", column = "product_id", javaType = Product.class, one = @One(select = "com.leayinge.dao.ProductDao.findById")), //javaType指的是Java类
            @Result(property = "member", column = "member_id", javaType = Member.class, one = @One(select = "com.leayinge.dao.MemberDao.findById")), //one指的是只有一个数据
            @Result(property = "travellers", column = "order_id", javaType = java.util.List.class, many = @Many(select = "com.leayinge.dao.TravellerDao.findByOrderId"))  //java类型是个list，many指的是返回不止一个数据
    })
    public Order findById(Integer orderId) throws Exception;

}

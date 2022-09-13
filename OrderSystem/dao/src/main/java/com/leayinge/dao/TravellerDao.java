package com.leayinge.dao;

import com.leayinge.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {

    @Select("select * from `traveller`")
    List<Traveller> findAll() throws Exception;

    @Select("select * from `traveller` where `traveller_id`=#{travellerId}")
    Traveller findById(Integer id) throws Exception;

    @Select("select * from `traveller` where `traveller_id` in (select `traveller_id` from `order_traveller` where `order_id`=#{orderId})") //从中间表获取
    List<Traveller> findByOrderId(Integer orderId) throws Exception;

}

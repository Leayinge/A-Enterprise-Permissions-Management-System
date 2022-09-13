package com.leayinge.dao;

import com.leayinge.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

//用于持久化操作
public interface ProductDao {

    //查询所有产品信息
//    @Select("select * from `product`")
//    List<Product> findAll() throws Exception;

    @Select("select * from `product`")
    List<Product> findAll() throws Exception;

    @Insert("insert into `product`(`product_name`,`city_name`,`departure_time`,`product_price`,`product_desc`,`product_status`) values(#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Select("select * from `product` where `product_id`=#{productId}")
    Product findById(Integer productId) throws Exception;

}

package com.leayinge.service;

import com.leayinge.domain.Product;

import java.util.List;

//服务层
public interface ProductService {

    List<Product> findAll(int page,int size) throws Exception;

    void save(Product product) throws Exception;

    Product findById(Integer productId) throws Exception;
}

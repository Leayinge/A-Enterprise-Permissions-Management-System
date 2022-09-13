package com.leayinge.service.Impl;

import com.github.pagehelper.PageHelper;
import com.leayinge.dao.ProductDao;
import com.leayinge.domain.Product;
import com.leayinge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //服务层
@Transactional //事务
public class ProductServiceImpl implements ProductService { //实现服务的接口

    @Autowired
    private ProductDao productDao; //获得一个持久层对象

    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return productDao.findAll(); //返回持久层给的数据
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public Product findById(Integer productId) throws Exception {
        return productDao.findById(productId);
    }
}

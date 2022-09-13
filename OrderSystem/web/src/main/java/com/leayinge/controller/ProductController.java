package com.leayinge.controller;


import com.github.pagehelper.PageInfo;
import com.leayinge.domain.Product;
import com.leayinge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController { //解决了web里的controller依赖问题

    @Autowired
    private ProductService productService; //可以顺便解决applicationContext的依赖问题

    @RequestMapping("/save.do")
    @Secured({"ROLE_ADMIN","ROLE_LEAYINGE"})
    public String save(Product product) throws Exception { //产品添加
        productService.save(product);
        return "redirect:findAll.do"; //插入完数据，重定向到查询所有
    }

    @RequestMapping("/findAll.do") //controller只处理.do请求，在前端控制器说明了
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "2") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page, size);
        PageInfo pageInfo = new PageInfo<>(ps);
        mv.addObject("pageinfo", pageInfo); //获取的对象和对象名
        mv.setViewName("product-page-list"); //视图名,也就是进入/product/findAll.do后跳转的页面
        return mv;
    }

}

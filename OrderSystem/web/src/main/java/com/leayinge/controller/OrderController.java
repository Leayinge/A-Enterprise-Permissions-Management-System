package com.leayinge.controller;

import com.github.pagehelper.PageInfo;
import com.leayinge.domain.Order;
import com.leayinge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findbyid.do")
    @Secured({"ROLE_ADMIN","ROLE_LEAYINGE"})
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer orderId) throws Exception { //url传入的名为id的参数
        ModelAndView mv = new ModelAndView();
        Order ordersList = orderService.findById(orderId);
        mv.addObject("orders", ordersList);
        mv.setViewName("order-show");
        return mv;
    }

    @RequestMapping("/findAll.do") //RequestParam是把url的参数识别进来
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "2") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Order> ordersList = orderService.findAll(page, size);
        PageInfo pageInfo = new PageInfo<>(ordersList); //PageInfo存储着分页的其他信息
        mv.addObject("pageinfo", pageInfo);
        mv.setViewName("order-page-list");
        return mv;
    }

}

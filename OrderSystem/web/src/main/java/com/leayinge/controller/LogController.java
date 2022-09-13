package com.leayinge.controller;

import com.github.pagehelper.PageInfo;
import com.leayinge.domain.Log;
import com.leayinge.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Log> logList = logService.findAll(page, size);
        PageInfo pageInfo = new PageInfo<>(logList);
        mv.addObject("logPageInfo", pageInfo);
        mv.setViewName("log-page-list");
        return mv;
    }

}

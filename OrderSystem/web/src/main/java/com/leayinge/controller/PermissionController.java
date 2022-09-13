package com.leayinge.controller;

import com.github.pagehelper.PageInfo;
import com.leayinge.domain.Permission;
import com.leayinge.service.PermissionService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "2") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> list = permissionService.findAll(page, size);
        PageInfo pageInfo = new PageInfo<>(list);
        mv.addObject("permissionPageInfo", pageInfo);
        mv.setViewName("permission-page-list");
        return mv;
    }

    @RequestMapping("/save.do")
    @Secured({"ROLE_ADMIN","ROLE_LEAYINGE"})
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

}

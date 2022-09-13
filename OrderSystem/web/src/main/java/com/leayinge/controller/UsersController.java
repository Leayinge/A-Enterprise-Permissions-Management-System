package com.leayinge.controller;

import com.github.pagehelper.PageInfo;
import com.google.protobuf.Internal;
import com.leayinge.domain.Role;
import com.leayinge.domain.Users;
import com.leayinge.service.RoleService;
import com.leayinge.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "2") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Users> list = usersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo<>(list);
        mv.addObject("usersPageInfo", pageInfo);
        mv.setViewName("users-page-list");
        return mv;
    }

    @RequestMapping("/save.do")
    @Secured({"ROLE_ADMIN", "ROLE_LEAYINGE"})
    public String save(Users users) throws Exception {
        usersService.save(users);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findbyid.do")
    @Secured({"ROLE_ADMIN", "ROLE_LEAYINGE"})
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer usersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Users users = usersService.findById(usersId);
        mv.addObject("user", users);
        mv.setViewName("users-show");
        return mv;
    }

    @RequestMapping("/findOtherRole.do")
    @Secured({"ROLE_ADMIN", "ROLE_LEAYINGE"})
    public ModelAndView findOtherRole(@RequestParam(name = "id", required = true) Integer userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Users users = usersService.findById(userId);
        List<Role> otherRole = roleService.findOtherRole(userId);
        mv.addObject("users", users);
        mv.addObject("otherRole", otherRole);
        mv.setViewName("users-role-add");
        return mv;
    }

    @RequestMapping("/addRole.do")
    @Secured({"ROLE_ADMIN", "ROLE_LEAYINGE"})
    public String saveRole(Integer[] ids, Integer userId) throws Exception {
        for (int i : ids) usersService.saveRole(userId, i);
        return "redirect:findAll.do";
    }


}

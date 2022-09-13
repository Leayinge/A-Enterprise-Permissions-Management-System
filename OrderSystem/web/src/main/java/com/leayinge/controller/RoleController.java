package com.leayinge.controller;

import com.github.pagehelper.PageInfo;
import com.leayinge.domain.Permission;
import com.leayinge.domain.Role;
import com.leayinge.service.PermissionService;
import com.leayinge.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "2") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> list = roleService.findAll(page, size);
        PageInfo pageInfo = new PageInfo<>(list);
        mv.addObject("rolePageInfo", pageInfo);
        mv.setViewName("role-page-list");
        return mv;
    }

    @RequestMapping("/save.do")
    @Secured({"ROLE_ADMIN","ROLE_LEAYINGE"})
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findOtherPermission.do")
    @Secured({"ROLE_ADMIN","ROLE_LEAYINGE"})
    public ModelAndView findOtherPermission(@RequestParam(name = "id", required = true) Integer roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> otherPermission = permissionService.findOtherPermission(roleId);
        Role role = roleService.findById(roleId);
        mv.addObject("otherPermission", otherPermission);
        mv.addObject("role", role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/savePermission.do")
    @Secured({"ROLE_ADMIN","ROLE_LEAYINGE"})
    public String savePermission(Integer[] ids, Integer roleId) throws Exception {
        for (int i : ids) roleService.savePermission(roleId, i);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findbyid.do")
    @Secured({"ROLE_ADMIN","ROLE_LEAYINGE"})
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }
}

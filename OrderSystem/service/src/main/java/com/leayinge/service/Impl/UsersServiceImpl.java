package com.leayinge.service.Impl;

import com.github.pagehelper.PageHelper;
import com.leayinge.dao.RoleDao;
import com.leayinge.dao.UsersDao;
import com.leayinge.domain.Role;
import com.leayinge.domain.Users;
import com.leayinge.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("usersService") //给bean命名，让spring-security知道这个bean
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Users> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return usersDao.findAll();
    }

    @Override
    public void save(Users users) throws Exception {
        usersDao.save(users);
    }

    @Override
    public Users findById(Integer userId) throws Exception {
        return usersDao.findById(userId);
    }

    @Override
    public void saveRole(Integer userId, Integer roleId) throws Exception {
        usersDao.saveRole(userId, roleId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) { //实现了UserDetailsService的类
        //UserDetails是一个封装用户的类，像spring security传递他需要的用户信息，这个的web/controller层由Spring security负责，我们不用理
        Users users = null;
        User user = null;
        try {
            users = usersDao.findByUsername(username);
            //通过User把用户名和密码，以及角色传递给spring security，让他认证
            //通过结构图发现User是UserDetails的一个实现，spring security写好的
            user = new User(users.getUsername(), "{noop}" + users.getPassword(), users.getStatus() == 1, true, true, true, getAuthority(users.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //通过进入User类，发现User第三个参数是一个授权接口，进入授权接口，通过结构发现简单授权类，通过SimpleGrantedAuthorities来进行授权操作
    List<SimpleGrantedAuthority> getAuthority(Integer userId) throws Exception {
        List<Role> roleList = roleDao.findByUserId(userId);
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role r : roleList) list.add(new SimpleGrantedAuthority(r.getRoleName()));
//        list.add(new SimpleGrantedAuthority("ROLE_ABC")); //进入简单授权类，发现构造函数就是给个角色名
        return list;
    }

}

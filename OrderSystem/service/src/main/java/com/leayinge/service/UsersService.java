package com.leayinge.service;

import com.leayinge.domain.Users;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsersService extends UserDetailsService { //要是用spring security，UsersService需要继承UserDetailsService，这个是spring security处理数据的方式

    List<Users> findAll(int page, int size) throws Exception;

    void save(Users users) throws Exception;

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    Users findById(Integer userId) throws Exception;

    void saveRole(Integer userId, Integer roleId) throws Exception;

}

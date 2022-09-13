package com.leayinge.dao;

import com.leayinge.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface UsersDao {

    @Select("select * from `users`")
    public List<Users> findAll() throws Exception;

    @Insert("insert into `users`(`email`,`username`,`password`,`phone_num`,`status`) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(Users users) throws Exception;

    @Select("select * from `users` where `username`=#{username}")
    public Users findByUsername(String username) throws Exception;

    @Select("select * from `users` where `user_id`=#{usersId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phone_num"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "user_id", javaType = java.util.List.class, many = @Many(select = "com.leayinge.dao.RoleDao.findByUserId"))
    })
    public Users findById(Integer usersId) throws Exception;

    @Select("select * from `users` where `user_id` in (select `user_id` from `users_role` where `role_id`=#{roleId})")
    public List<Users> findByRoleId(Integer roleId) throws Exception;

    @Insert("insert into `users_role`(`users_id`,`role_id`) values(#{userId},#{roleId})")
    public void saveRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId) throws Exception; //如果dao有多个参数，那么需要@Param指定参数名，不然他用默认就不能识别了

}

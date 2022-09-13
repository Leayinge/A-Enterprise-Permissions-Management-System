package com.leayinge.dao;

import com.leayinge.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    @Select("select * from `role` where `role_id` in (select `role_id` from `users_role` where `users_id`=#{userId})")
    @Results({
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "roleDesc", column = "role_desc"),
            @Result(property = "permissions", column = "role_id", javaType = java.util.List.class, many = @Many(select = "com.leayinge.dao.PermissionDao.findByRoleId"))
    })
    public List<Role> findByUserId(Integer userId) throws Exception; //虽然查出一堆role，但也可以用result映射结果，绑定多个相关的permission

    @Select("select * from `role`")
    public List<Role> findAll() throws Exception;

    @Select("select * from `role` where `role_id` = #{roleId}")
    @Results({
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "roleDesc", column = "role_desc"),
            @Result(property = "permissions", column = "role_id", javaType = java.util.List.class, many = @Many(select = "com.leayinge.dao.PermissionDao.findByRoleId")),
            @Result(property = "users", column = "role_id", javaType = java.util.List.class, many = @Many(select = "com.leayinge.dao.UsersDao.findByRoleId"))
    })
    public Role findById(Integer roleId) throws Exception;

    @Insert("insert into `role`(`role_name`,`role_desc`) values(#{roleName},#{roleDesc})")
    public void save(Role role);

    @Select("select * from `role` where `role_id` not in (select `role_id` from `users_role` where `users_id` = #{userId})")
    public List<Role> findOtherRole(Integer userId) throws Exception;

    @Insert("insert into `role_permission`(`role_id`,`permission_id`) values(#{roleId},#{permissionId})")
    public void savePermission(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId) throws Exception;

}

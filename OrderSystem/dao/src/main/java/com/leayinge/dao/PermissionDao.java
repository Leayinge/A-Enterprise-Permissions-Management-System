package com.leayinge.dao;

import com.leayinge.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select * from `permission` where `permission_id` in (select `permission_id` from `role_permission` where `role_id`=#{roleId})")
    public List<Permission> findByRoleId(Integer roleId) throws Exception;

    @Select("select * from `permission`")
    public List<Permission> findAll() throws Exception;

    @Insert("insert into `permission`(`permission_name`,`url`) values(#{permissionName},#{url})")
    public void save(Permission permission) throws Exception;

    @Select("select * from `permission` where `permission_id` not in (select `permission_id` from `role_permission` where `role_id`=#{roleId})")
    public List<Permission> findOtherPermission(Integer roleId) throws Exception;

}

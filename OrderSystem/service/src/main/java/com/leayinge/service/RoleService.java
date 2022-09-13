package com.leayinge.service;

import com.leayinge.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll(int page, int size) throws Exception;

    void save(Role role) throws Exception;

    public List<Role> findOtherRole(Integer userId) throws Exception;

    public void savePermission(Integer roleId, Integer permissionId) throws Exception;

    public Role findById(Integer roleId) throws Exception;
}

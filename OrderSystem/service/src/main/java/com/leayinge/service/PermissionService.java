package com.leayinge.service;

import com.leayinge.domain.Permission;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PermissionService {

    public void save(Permission permission) throws Exception;

    public List<Permission> findAll(int page, int size) throws Exception;

    public List<Permission> findOtherPermission(Integer roleId) throws Exception;

    public List<Permission> findByRoleId(Integer roleId) throws Exception;

}

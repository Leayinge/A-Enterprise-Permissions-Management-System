package com.leayinge.service.Impl;

import com.github.pagehelper.PageHelper;
import com.leayinge.dao.PermissionDao;
import com.leayinge.domain.Permission;
import com.leayinge.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findOtherPermission(Integer roleId) throws Exception {
        return permissionDao.findOtherPermission(roleId);
    }

    @Override
    public List<Permission> findByRoleId(Integer roleId) throws Exception {
        return permissionDao.findByRoleId(roleId);
    }
}

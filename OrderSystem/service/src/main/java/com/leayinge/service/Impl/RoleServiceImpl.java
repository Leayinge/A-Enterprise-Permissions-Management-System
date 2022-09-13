package com.leayinge.service.Impl;

import com.github.pagehelper.PageHelper;
import com.leayinge.dao.RoleDao;
import com.leayinge.domain.Role;
import com.leayinge.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRole(Integer userId) throws Exception {
        return roleDao.findOtherRole(userId);
    }

    @Override
    public void savePermission(Integer roleId, Integer permissionId) throws Exception {
        roleDao.savePermission(roleId, permissionId);
    }

    @Override
    public Role findById(Integer roleId) throws Exception {
        return roleDao.findById(roleId);
    }

}

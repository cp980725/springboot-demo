package com.cp.stuspringbootdemo.service.Impl;

import com.cp.stuspringbootdemo.dao.RoleMapper;
import com.cp.stuspringbootdemo.domain.Permission;
import com.cp.stuspringbootdemo.domain.Role;
import com.cp.stuspringbootdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper rolemapper;
    @Override
    public boolean addRole(Role role) {
        return rolemapper.addRole(role);
    }

    @Override
    public boolean updRole(Role role) {
        return rolemapper.updRole(role);
    }

    @Override
    public Role selRole(Integer id) {
        return rolemapper.selRole(id);
    }

    @Override
    public boolean delRole(Integer id) {
        return rolemapper.delRole(id);
    }

    @Override
    public List<Permission> getPermissionByRoleId(List<Integer> roleid) {
        return rolemapper.getPermissionByRoleId(roleid);
    }
}

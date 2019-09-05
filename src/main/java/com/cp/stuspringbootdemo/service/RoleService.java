package com.cp.stuspringbootdemo.service;

import com.cp.stuspringbootdemo.domain.Permission;
import com.cp.stuspringbootdemo.domain.Role;

import java.util.List;

public interface RoleService {
    public boolean addRole(Role role);
    public boolean updRole(Role role);
    public Role selRole(Integer id);
    public boolean delRole(Integer id);
    List<Permission> getPermissionByRoleId(List<Integer> roleid);
}

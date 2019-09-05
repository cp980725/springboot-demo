package com.cp.stuspringbootdemo.dao;

import com.cp.stuspringbootdemo.domain.Permission;
import com.cp.stuspringbootdemo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    boolean addRole(Role role);
    boolean updRole(Role role);
    Role selRole(Integer id);
    boolean delRole(Integer id);
    List<Permission> getPermissionByRoleId(List<Integer> roleid);
}

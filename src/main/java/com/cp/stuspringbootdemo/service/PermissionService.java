package com.cp.stuspringbootdemo.service;

import com.cp.stuspringbootdemo.domain.Permission;

public interface PermissionService {
    boolean addPer(Permission per);
    boolean updPer(Permission per);
    Permission selPer(Integer id);
    boolean delPer(Integer id);
}

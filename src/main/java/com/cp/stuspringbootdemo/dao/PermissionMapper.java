package com.cp.stuspringbootdemo.dao;

import com.cp.stuspringbootdemo.domain.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper {
    boolean addPer(Permission per);
    boolean updPer(Permission per);
    Permission selPer(Integer id);
    boolean delPer(Integer id);
}

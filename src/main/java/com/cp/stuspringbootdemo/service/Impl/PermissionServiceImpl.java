package com.cp.stuspringbootdemo.service.Impl;

import com.cp.stuspringbootdemo.dao.PermissionMapper;
import com.cp.stuspringbootdemo.domain.Permission;
import com.cp.stuspringbootdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permapper;

    @Override
    public boolean addPer(Permission per) {
        return permapper.addPer(per);
    }

    @Override
    public boolean updPer(Permission per) {
        return permapper.updPer(per);
    }

    @Override
    public Permission selPer(Integer id) {
        return permapper.selPer(id);
    }

    @Override
    public boolean delPer(Integer id) {
        return permapper.delPer(id);
    }
}

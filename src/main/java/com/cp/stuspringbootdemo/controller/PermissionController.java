package com.cp.stuspringbootdemo.controller;

import com.cp.stuspringbootdemo.domain.Permission;
import com.cp.stuspringbootdemo.service.Impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PermissionController {
    @Autowired
    private PermissionServiceImpl permissionservice;

    @RequestMapping("/addPer/{id}/{permission}/{roleid}")
    public Object addPer(@PathVariable Integer id, @PathVariable String permission, @PathVariable Integer roleid){
        Permission per=new Permission();
        per.setId(id);
        per.setPermission(permission);
        per.setRoleid(roleid);
        boolean flag=permissionservice.addPer(per);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

    @RequestMapping("/updPer/{id}/{permission}/{roleid}")
    public Object updPer(@PathVariable Integer id, @PathVariable String permission, @PathVariable Integer roleid){
        Permission per=new Permission();
        per.setId(id);
        per.setPermission(permission);
        per.setRoleid(roleid);
        boolean flag=permissionservice.updPer(per);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

    @RequestMapping("/selPer/{id}")
    public Object selPer(@PathVariable Integer id){
        Permission per=permissionservice.selPer(id);
        return per;
    }

    @RequestMapping("/delPer/{id}")
    public Object delPer(@PathVariable Integer id){
        boolean flag=permissionservice.delPer(id);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }
}

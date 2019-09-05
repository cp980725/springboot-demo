package com.cp.stuspringbootdemo.controller;

import com.cp.stuspringbootdemo.domain.Permission;
import com.cp.stuspringbootdemo.domain.Role;
import com.cp.stuspringbootdemo.service.Impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    private RoleServiceImpl roleservice;

    @RequestMapping("/addRole/{id}/{rolename}/{userid}")
    public Object addRole(@PathVariable Integer id, @PathVariable String rolename, @PathVariable Integer userid){
        Role role=new Role();
        role.setId(id);
        role.setRolename(rolename);
        role.setUserid(userid);
        boolean flag=roleservice.addRole(role);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

    @RequestMapping("/updRole/{id}/{rolename}/{userid}")
    public Object updRole(@PathVariable Integer id, @PathVariable String rolename, @PathVariable Integer userid){
        Role role=new Role();
        role.setId(id);
        role.setRolename(rolename);
        role.setUserid(userid);
        boolean flag=roleservice.updRole(role);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

    @RequestMapping("/selRole/{id}")
    public Object selRole(@PathVariable Integer id){
        Role role=roleservice.selRole(id);
        return role;
    }

    @RequestMapping("/delRole/{id}")
    public Object delRole(@PathVariable Integer id){
        boolean flag=roleservice.delRole(id);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

}

package com.cp.stuspringbootdemo.controller;

import com.cp.stuspringbootdemo.domain.Permission;
import com.cp.stuspringbootdemo.domain.Role;
import com.cp.stuspringbootdemo.domain.User;
import com.cp.stuspringbootdemo.service.Impl.RoleServiceImpl;
import com.cp.stuspringbootdemo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userservice;
    @Autowired
    private RoleServiceImpl roleservice;

    @RequestMapping("/addDate/{id}/{username}/{password}/{sal}")
    public Object addDate(@PathVariable Integer id,@PathVariable String username,@PathVariable String password,@PathVariable Double sal){
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setSal(sal);
        boolean flag=userservice.addDate(user);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

    @RequestMapping("/updDate/{id}/{username}/{password}/{sal}")
    public Object updDate(@PathVariable Integer id,@PathVariable String username,@PathVariable String password,@PathVariable Double sal){
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setSal(sal);
        boolean flag=userservice.updDate(user);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

    @RequestMapping("/selDate/{id}")
    public Object selDate(@PathVariable Integer id){
        User user=userservice.selDate(id);
        return user;
    }

    @RequestMapping("/delDate/{id}")
    public Object delDate(@PathVariable Integer id){
        boolean flag=userservice.delDate(id);
        Map<String, Object> result = new HashMap<String, Object>();
        if(flag){
            result.put("code", 0);
        }else{
            result.put("code", -1);
        }
        return result;
    }

    @RequestMapping("/getByParamaterKey/{username}")
    public  List<Permission> getByParamaterKey(@PathVariable  String username){
        List<Role> list=userservice.getRoleByUserName(username);
        List<Integer>roleid=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            roleid.add(i,list.get(i).getId());
        }
        System.out.println(roleid);
        List<Permission> listPer=roleservice.getPermissionByRoleId(roleid);
        return listPer;
    }

    @RequestMapping("/getPwd/{username}")
    public Object getPwd(@PathVariable String username){
        String password=userservice.getPwdByName(username);
        return password;
    }
}

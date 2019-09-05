package com.cp.stuspringbootdemo.controller;

import com.cp.stuspringbootdemo.service.Impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiroController {
    @Autowired
    private UserServiceImpl userservice;

    @RequestMapping("/loginShiro/{username}/{password}")
    public Object loginShiro(@PathVariable String username,@PathVariable String password){
        if(username !=null){
            String pwd=userservice.getPwdByName(username);
            if(pwd !=null && pwd.equals(password)){
                //添加用户认证信息
                Subject subject= SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
                //进行验证，这里可以捕获异常，然后返回对应信息
                subject.login(usernamePasswordToken);
                System.out.println("loginShiro:"+usernamePasswordToken);
                return "loginShiro!";
            }
        }
        return "it is logout!";
    }
    @RequestMapping("/logout")
    public Object logout(){
        return "logout!";
    }
    @RequestMapping("/index")
    public Object index(){
        return "index!";
    }
    @RequestMapping("/errorpage")
    public Object errorpage(){
        return "errorpage!";
    }

    //业务方法
    @RequestMapping("/testShiro")
    public Object testShiro(){
        return "testShiro:success!";
    }

    //认证角色
    @RequestMapping("/testAuthority")
    @RequiresRoles(value = {"role20","role10"},logical = Logical.OR)
    public Object testAuthority(){
        return "testAuthority";
    }
    //认证权限
    @RequestMapping("/testAuthorityPermission")
    @RequiresPermissions(value = {"update","select"},logical = Logical.OR)
    public Object testAuthorityPermission(){
        return "testAuthorityPermission";
    }
}

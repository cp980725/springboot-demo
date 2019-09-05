package com.cp.stuspringbootdemo.service.Impl;

import com.cp.stuspringbootdemo.dao.UserMapper;
import com.cp.stuspringbootdemo.domain.Role;
import com.cp.stuspringbootdemo.domain.User;
import com.cp.stuspringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Override
    public boolean addDate(User user) {
        return usermapper.addDate(user);
    }

    @Override
    public boolean updDate(User user) {
        return usermapper.updDate(user);
    }

    @Override
    public User selDate(Integer id) {
        return usermapper.selDate(id);
    }

    @Override
    public boolean delDate(Integer id) {
        return usermapper.delDate(id);
    }

    @Override
    public List<Role> getRoleByUserName(String username) {
        return usermapper.getRoleByUserName(username);
    }

    @Override
    public String getPwdByName(String username) {
        return usermapper.getPwdByName(username);
    }


}

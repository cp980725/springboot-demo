package com.cp.stuspringbootdemo.service;

import com.cp.stuspringbootdemo.domain.Role;
import com.cp.stuspringbootdemo.domain.User;

import java.util.List;

public interface UserService {
     boolean addDate(User user);
     boolean updDate(User user);
     User selDate(Integer id);
     boolean delDate(Integer id);
    List<Role> getRoleByUserName(String username);

    String getPwdByName(String username);
}

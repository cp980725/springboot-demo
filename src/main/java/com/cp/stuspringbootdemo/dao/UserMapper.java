package com.cp.stuspringbootdemo.dao;

import com.cp.stuspringbootdemo.domain.Role;
import com.cp.stuspringbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
     boolean addDate(User user);
     boolean updDate(User user);
     User selDate(Integer id);
     boolean delDate(Integer id);
     List<Role> getRoleByUserName(String username);

     String getPwdByName(String username);
}


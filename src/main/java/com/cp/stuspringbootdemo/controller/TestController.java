package com.cp.stuspringbootdemo.controller;

import com.cp.stuspringbootdemo.config.jedis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;


@RestController
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        return "hello word";
    }

    @RequestMapping(value = "/rest/{name}")
    public Object restTest(@PathVariable String name){
        return "restTest:"+name;
    }

    @Autowired
    private JedisUtil jedis;
    @RequestMapping(value = "/restJedis/{val}")
    public Object restJedis(@PathVariable String val){
        jedis.set("key:"+val,val);
        return "restJedis_OK";
    }

    @Autowired
    private JdbcTemplate jdbctemplate;
    @RequestMapping("/getJdbc/{id}")
    public Object getJdbc(@PathVariable Integer id){
        String sql="select * from User where id="+id;
        Map<String,Object> data=jdbctemplate.queryForMap(sql);
        return data;
    }
}


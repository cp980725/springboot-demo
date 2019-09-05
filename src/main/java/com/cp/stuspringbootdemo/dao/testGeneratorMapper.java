package com.cp.stuspringbootdemo.dao;

import com.cp.stuspringbootdemo.domain.testGenerator;

public interface testGeneratorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(testGenerator record);

    int insertSelective(testGenerator record);

    testGenerator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(testGenerator record);

    int updateByPrimaryKey(testGenerator record);
}
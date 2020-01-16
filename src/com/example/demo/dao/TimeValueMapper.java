package com.example.demo.dao;

import com.example.demo.pojo.TimeValue;

public interface TimeValueMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(TimeValue record);

    int insertSelective(TimeValue record);

    TimeValue selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(TimeValue record);

    int updateByPrimaryKey(TimeValue record);
}
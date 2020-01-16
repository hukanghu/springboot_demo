package com.example.demo.dao;

import com.example.demo.pojo.StudentClass;

public interface StudentClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentClass record);

    int insertSelective(StudentClass record);

    StudentClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentClass record);

    int updateByPrimaryKey(StudentClass record);
}
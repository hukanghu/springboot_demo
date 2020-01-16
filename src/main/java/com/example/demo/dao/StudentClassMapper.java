package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.StudentClass;

@Mapper
public interface StudentClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentClass record);

    int insertSelective(StudentClass record);

    StudentClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentClass record);

    int updateByPrimaryKey(StudentClass record);
}
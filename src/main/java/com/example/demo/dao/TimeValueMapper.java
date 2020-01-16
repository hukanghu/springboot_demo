package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import com.example.demo.pojo.TimeValue;

@Mapper
public interface TimeValueMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(TimeValue record);

    int insertSelective(TimeValue record);

    TimeValue selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(TimeValue record);

    int updateByPrimaryKey(TimeValue record);
    
    @Select("SELECT * FROM TIME_VALUE")
    List<TimeValue> SelectTimeValues();
    
    @Select("select * from TIME_VALUE where YearValue=#{yearvalue} and MonthValue=#{monthvalue} and DayValue=#{dayvalue}")
    List<TimeValue> selectbyday(@Param("yearvalue") String yearvalue,@Param("monthvalue") String monthvalue,@Param("dayvalue") String dayvalue);

    @Select("select * from TIME_VALUE where time_value > #{starttime} and time_value < #{endtime}")
    List<TimeValue> selectbytime(@Param("starttime") String starttime,@Param("endtime") String endtime);

    
}
package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.TimeDay;

@Mapper
public interface TimeDayMapper {

	@Select("select * from TIME_DAY")
	List<TimeDay> selecTimeDays();
	
}

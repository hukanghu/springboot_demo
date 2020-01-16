package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.TimeDayMapper;
import com.example.demo.dao.TimeValueMapper;
import com.example.demo.pojo.TimeDay;
import com.example.demo.pojo.TimeValue;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/TimeValue")
public class TimeValueController {

	@Autowired
	private TimeValueMapper TimeValueMapper;
	
	@Autowired
	private TimeDayMapper TimeDayMapper;
	
	@RequestMapping("/SelectAll")
	public String  selecTimeValues(Model model){
		List<TimeValue> ti=TimeValueMapper.SelectTimeValues();
		model.addAttribute("timevalue", ti);
		return "DataGrid/DataGrid";
	}
	
	@RequestMapping("/SelectAll1")
	@ResponseBody
	public Object  selecTimeValues_1(Model model){
		List<TimeValue> ti=TimeValueMapper.SelectTimeValues();
		model.addAttribute("timevalue", ti);
		return ti;
	}
	
	@ResponseBody
	@RequestMapping(value="/pageInfo",produces = "html/text;charset=UTF-8")
	public String pageInfo(@RequestParam int pageNumber,int pageSize,HttpServletResponse response) {
		response.setContentType("text/json");
        System.out.println(pageNumber+"===="+pageSize);
        response.setCharacterEncoding("utf-8");
        
        //userList查询要放到startPage下面
        PageHelper.startPage(pageNumber,pageSize);
        List<TimeValue> userList=TimeValueMapper.SelectTimeValues();
        PageInfo<TimeValue> page=new PageInfo<>(userList);
          //取出查询结果
        List<TimeValue> rows = page.getList();
        int total = (int) page.getTotal();
         //转换为json数据
        JSONObject result = new JSONObject();
        result.put("rows",rows);
        result.put("total",total);
        System.out.println(result.toJSONString());
        return result.toJSONString();
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getbysomevalue",produces = "html/text;charset=UTF-8")
	public String getbysomevalue(@RequestParam int pageNumber,int pageSize,String yearvalue,String monthvalue,String dayvalue,HttpServletResponse response) {
		response.setContentType("text/json");
        System.out.println(pageNumber+"===="+pageSize);
        response.setCharacterEncoding("utf-8");
        
        //userList查询要放到startPage下面
        PageHelper.startPage(pageNumber,pageSize);
       // List<TimeValue> userList=TimeValueMapper.SelectTimeValues();
        
        List<TimeValue> userList = TimeValueMapper.selectbyday(yearvalue, monthvalue, dayvalue);
        
        PageInfo<TimeValue> page=new PageInfo<>(userList);
          //取出查询结果
        List<TimeValue> rows = page.getList();
        int total = (int) page.getTotal();
         //转换为json数据
        JSONObject result = new JSONObject();
        result.put("rows",rows);
        result.put("total",total);
        System.out.println(result.toJSONString());
        return result.toJSONString();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/gettimeday",produces = "html/text;charset=UTF-8")
	public String gettimeday(@RequestParam int pageNumber,int pageSize,HttpServletResponse response) {
		response.setContentType("text/json");
        System.out.println(pageNumber+"===="+pageSize);
        response.setCharacterEncoding("utf-8");
		
        PageHelper.startPage(pageNumber,pageSize);
        
		List<TimeDay> timeDays = TimeDayMapper.selecTimeDays();
		
		
		PageInfo<TimeDay> page=new PageInfo<>(timeDays);
        //取出查询结果
	    List<TimeDay> rows = page.getList();
	    int total = (int) page.getTotal();
	    //转换为json数据
	    JSONObject result = new JSONObject();
	    result.put("rows",rows);
	    result.put("total",total);
	    System.out.println(result.toJSONString());
	    return result.toJSONString();
        
        
	}
	
	
	
	
	
	
}

package com.example.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.TimeValueMapper;
import com.example.demo.pojo.TimeValue;
import com.example.demo.utils.ExcelUtil;

@Controller
@RequestMapping("/util")
public class UtilController {

	@Autowired
	private TimeValueMapper TimeValueMapper;
	
	@RequestMapping("/excelExport")
	public void excelutil(HttpServletResponse response) throws IOException {
		
		//表头数据
        String[] header = {"ID", "姓名", "性别", "年龄", "地址", "分数"};

        //数据内容
        String[] student1 = {"1", "小红", "女", "23", "成都青羊区", "96"};
        String[] student2 = {"2", "小强", "男", "26", "成都金牛区", "91"};
        String[] student3 = {"3", "小明", "男", "28", "成都武侯区", "90"};

        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称为"学生表"
        HSSFSheet sheet = workbook.createSheet("学生表");

        //设置表格列宽度为10个字节
        sheet.setDefaultColumnWidth(10);

        //创建第一行表头
        HSSFRow headrow = sheet.createRow(0);

        //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
        for (int i = 0; i < header.length; i++) {
            //创建一个单元格
            HSSFCell cell = headrow.createCell(i);

            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(header[i]);

            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
        }

        //模拟遍历结果集，把内容加入表格
        //模拟遍历第一个学生
        HSSFRow row1 = sheet.createRow(1);
        for (int i = 0; i < student1.length; i++) {
            HSSFCell cell = row1.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(student1[i]);
            cell.setCellValue(text);
        }

        //模拟遍历第二个学生
        HSSFRow row2 = sheet.createRow(2);
        for (int i = 0; i < student2.length; i++) {
            HSSFCell cell = row2.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(student2[i]);
            cell.setCellValue(text);
        }

        //模拟遍历第三个学生
        HSSFRow row3 = sheet.createRow(3);
        for (int i = 0; i < student3.length; i++) {
            HSSFCell cell = row3.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(student3[i]);
            cell.setCellValue(text);
        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //这后面可以设置导出Excel的名称，此例中名为student.xls
        response.setHeader("Content-disposition", "attachment;filename=student.xls");

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());
	}
	
	@RequestMapping("/excelExport_object")
	public void excelutiltwo(HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException, IOException {
		List<TimeValue> userList=TimeValueMapper.SelectTimeValues();

		
		
		List<List<String>> valueList = new ArrayList<List<String>>();

		List<String> headvalueList =new ArrayList<String>();
		
		headvalueList.add("PID");
		headvalueList.add("年");
		headvalueList.add("月");
		headvalueList.add("日");
		headvalueList.add("时");
		headvalueList.add("分");
		headvalueList.add("秒");
		headvalueList.add("星期");
		headvalueList.add("第几季度");
		headvalueList.add("当年第几周");
		headvalueList.add("当周第几天");
		headvalueList.add("当年第几天");
		headvalueList.add("当前日期");
		//headvalueList.add("sql");
		
		valueList.add(headvalueList);
	    
	    for (TimeValue timeValue : userList) {
	    	valueList.add(timeValue.toliStrings());
		}

	    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmssSSS");	
	    
	    String filenameString = simpleDateFormat.format(new Date());
	    
		ExcelUtil.exportExcel(response,valueList, "sheet1",filenameString+".xls", 15);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

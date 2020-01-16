package com.example.demo.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	/**
     * Excel表格导出
     * @param response HttpServletResponse对象
     * @param excelData Excel表格的数据，封装为List<List<String>>
     * @param sheetName sheet的名字
     * @param fileName 导出Excel的文件名
     * @param columnWidth Excel表格的宽度，建议为15
     * @throws IOException 抛IO异常
     */
    public static void exportExcel(HttpServletResponse response,
                                   List<List<String>> excelData, 
                                   String sheetName, 
                                   String fileName, 
                                   int columnWidth) throws IOException {

        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);

        //设置表格列宽度
        sheet.setDefaultColumnWidth(columnWidth);

        //写入List<List<String>>中的数据
        int rowIndex = 0;
        for(List<String> data : excelData){
            //创建一个row行，然后自增1
            HSSFRow row = sheet.createRow(rowIndex++);

            //遍历添加本行数据
            for (int i = 0; i < data.size(); i++) {
                //创建一个单元格
                HSSFCell cell = row.createCell(i);

                //创建一个内容对象
                HSSFRichTextString text = new HSSFRichTextString(data.get(i));

                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
            }
        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //设置导出Excel的名称
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());

        //关闭workbook
        workbook.close();
    }

    /**
     * Excel表格导出
     * @param response HttpServletResponse对象
     * @param excelData Excel表格的数据，封装为List<Object>
     * @param sheetName sheet的名字
     * @param fileName 导出Excel的文件名
     * @param columnWidth Excel表格的宽度，建议为15
     * @throws IOException 抛IO异常
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static void exportExcel(HttpServletResponse response,
                                   List<Object> excelData, 
                                   List<String> headvalue,
                                   String sheetName, 
                                   String fileName, 
                                   int columnWidth) throws IOException, IllegalArgumentException, IllegalAccessException {

        //声明一个工作簿
    	XSSFWorkbook workbook = new XSSFWorkbook();

        //生成一个表格，设置表格名称
        XSSFSheet sheet = workbook.createSheet(sheetName);

        //设置表格列宽度
        sheet.setDefaultColumnWidth(columnWidth);
        
        //先写表头数据
        int rowIndex = 0;
       //创建一个row行，然后自增1
        XSSFRow row1 = sheet.createRow(rowIndex);
        for (String  str : headvalue) {
        	//创建一个单元格
            XSSFCell cell = row1.createCell(0);

           
            //创建一个内容对象
            XSSFRichTextString text = new XSSFRichTextString(str);

            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
		}
        rowIndex++;
        //写入List<List<String>>中的数据
        for (int i = 0; i < excelData.size(); i++) {
        	
        	//创建一个row行，然后自增1
            XSSFRow row = sheet.createRow(rowIndex++);
        	
            Field[] fields = excelData.get(i).getClass().getDeclaredFields();
            Object oi = excelData.get(i);
            for (int j = 0; j < fields.length; j++) {
                if(!fields[j].isAccessible()){
                    fields[j].setAccessible(true);
                }
                //创建一个单元格
                XSSFCell cell = row.createCell(i);

                //创建一个内容对象
                XSSFRichTextString text = new XSSFRichTextString(fields[j].get(oi).toString());

                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text); 
               
            }
        }
        

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //设置导出Excel的名称
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());

        //关闭workbook
        workbook.close();
    }
    
}

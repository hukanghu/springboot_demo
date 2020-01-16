package com.example.demo.pojo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TimeValue {
    @Override
	public String toString() {
		return "TimeValue [pid=" + pid + ", yearvalue=" + yearvalue + ", monthvalue=" + monthvalue + ", dayvalue="
				+ dayvalue + ", hourvalue=" + hourvalue + ", mivalue=" + mivalue + ", ssvalue=" + ssvalue
				+ ", weekvalue=" + weekvalue + ", qValue=" + qValue + ", wwValue=" + wwValue + ", dValue=" + dValue
				+ ", dddValue=" + dddValue + ", timeValue=" + timeValue + ", sql=" + sql + "]";
	}
    
    public List<String> toliStrings(){
    	SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	List<String> list = new ArrayList<String>();
    	list.add(pid.toString());
    	list.add(yearvalue.toString());
    	list.add(monthvalue.toString());
    	list.add(dayvalue.toString());
    	list.add(hourvalue.toString());
    	list.add(mivalue.toString());
    	list.add(ssvalue.toString());
    	list.add(weekvalue.toString());
    	list.add(qValue.toString());
    	list.add(wwValue.toString());
    	list.add(dValue.toString());
    	list.add(dddValue.toString());
    	list.add(simpleDateFormat.format(timeValue).toString());
    	//list.add(sql.toString());
    	return list;
    	
    }
    
    
	private Integer pid;

    private String yearvalue;

    private String monthvalue;

    private String dayvalue;

    private String hourvalue;

    private String mivalue;

    private String ssvalue;

    private String weekvalue;

    private String qValue;

    private String wwValue;

    private String dValue;

    private String dddValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeValue;

    private String sql;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getYearvalue() {
        return yearvalue;
    }

    public void setYearvalue(String yearvalue) {
        this.yearvalue = yearvalue == null ? null : yearvalue.trim();
    }

    public String getMonthvalue() {
        return monthvalue;
    }

    public void setMonthvalue(String monthvalue) {
        this.monthvalue = monthvalue == null ? null : monthvalue.trim();
    }

    public String getDayvalue() {
        return dayvalue;
    }

    public void setDayvalue(String dayvalue) {
        this.dayvalue = dayvalue == null ? null : dayvalue.trim();
    }

    public String getHourvalue() {
        return hourvalue;
    }

    public void setHourvalue(String hourvalue) {
        this.hourvalue = hourvalue == null ? null : hourvalue.trim();
    }

    public String getMivalue() {
        return mivalue;
    }

    public void setMivalue(String mivalue) {
        this.mivalue = mivalue == null ? null : mivalue.trim();
    }

    public String getSsvalue() {
        return ssvalue;
    }

    public void setSsvalue(String ssvalue) {
        this.ssvalue = ssvalue == null ? null : ssvalue.trim();
    }

    public String getWeekvalue() {
        return weekvalue;
    }

    public void setWeekvalue(String weekvalue) {
        this.weekvalue = weekvalue == null ? null : weekvalue.trim();
    }

    public String getqValue() {
        return qValue;
    }

    public void setqValue(String qValue) {
        this.qValue = qValue == null ? null : qValue.trim();
    }

    public String getWwValue() {
        return wwValue;
    }

    public void setWwValue(String wwValue) {
        this.wwValue = wwValue == null ? null : wwValue.trim();
    }

    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue == null ? null : dValue.trim();
    }

    public String getDddValue() {
        return dddValue;
    }
    
    
    public void setDddValue(String dddValue) {
        this.dddValue = dddValue == null ? null : dddValue.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTimeValue() {
    	
        return timeValue;
    }
    
    public void setTimeValue(Date timeValue) {
        this.timeValue = timeValue;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql == null ? null : sql.trim();
    }
}
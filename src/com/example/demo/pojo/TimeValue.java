package com.example.demo.pojo;

import java.util.Date;

public class TimeValue {
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
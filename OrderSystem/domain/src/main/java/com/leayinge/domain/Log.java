package com.leayinge.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    private Integer logId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date visitTime;
    private String username;
    private String ip;
    private String url;
    private Integer executionTime;
    private String method;

    private String visitTimeStr;

    public String getVisitTimeStr() {
        if (visitTimeStr != null) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            visitTimeStr = ft.format(visitTime);
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

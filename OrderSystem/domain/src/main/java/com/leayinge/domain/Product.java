package com.leayinge.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

    private Integer productId;
    private String productName;
    private String cityName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;//用于格式转换页面显示
    private Double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr; //0：关闭，1：开启

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            departureTimeStr = ft.format(departureTime);
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            if (productStatus == 0) productStatusStr = "关闭";
            else productStatusStr = "开启";
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}

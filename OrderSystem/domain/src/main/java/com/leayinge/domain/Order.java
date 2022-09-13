package com.leayinge.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {

    private Integer orderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;
    private Integer peopleCount;
    private String orderDesc;
    private Integer payType;
    private Integer orderStatus;
    private String payTypeStr;
    private String orderTimeStr;
    private String orderStatusStr;
    private Product product;
    private List<Traveller> travellers;
    private Member member;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayTypeStr() {
        if (payType != null) {
            if (payType == 0) payTypeStr = "支付宝";
            else if (payType == 1) payTypeStr = "微信";
            else payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            orderTimeStr = ft.format(orderTime);
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public String getOrderStatusStr() {
        if (orderStatus != null) {
            if (orderStatus == 0) orderStatusStr = "未支付";
            else orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }
}

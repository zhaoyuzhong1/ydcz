package com.yd.dto;

import java.util.Date;

/**
 * Created by james on 2019/2/1.
 */
public class Car extends BaseDTO {
    private Integer id;
    private String title;
    private String color;
    private String issy;
    private double guiprice;
    private double price;
    private double downpay;
    private double monpay;
    private Date cdate;
    private String flag;
    private String imgpath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIssy() {
        return issy;
    }

    public void setIssy(String issy) {
        this.issy = issy;
    }

    public double getGuiprice() {
        return guiprice;
    }

    public void setGuiprice(double guiprice) {
        this.guiprice = guiprice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDownpay() {
        return downpay;
    }

    public void setDownpay(double downpay) {
        this.downpay = downpay;
    }

    public double getMonpay() {
        return monpay;
    }

    public void setMonpay(double monpay) {
        this.monpay = monpay;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}

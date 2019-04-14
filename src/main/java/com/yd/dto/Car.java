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
    private String companyname;
    private Integer sailnum;
    private String tcase;//参团情况
    private String type;//区分车辆情况
    private String depict;//二手车描述
    private Integer km;
    private Integer cuser;
    private String cusername;
    private Integer companyid;
    private String imgname;
    private Integer shopid;

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

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Integer getSailnum() {
        return sailnum;
    }

    public void setSailnum(Integer sailnum) {
        this.sailnum = sailnum;
    }

    public String getTcase() {
        return tcase;
    }

    public void setTcase(String tcase) {
        this.tcase = tcase;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getCuser() {
        return cuser;
    }

    public void setCuser(Integer cuser) {
        this.cuser = cuser;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }
}

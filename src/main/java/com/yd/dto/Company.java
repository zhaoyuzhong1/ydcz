package com.yd.dto;

import com.sun.xml.internal.rngom.binary.DataExceptPattern;

import java.util.Date;

/**
 * Created by james on 2019/2/14.
 */
public class Company extends BaseDTO {
    private Integer id;
    private String name;
    private String isyx;
    private Date cdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsyx() {
        return isyx;
    }

    public void setIsyx(String isyx) {
        this.isyx = isyx;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}

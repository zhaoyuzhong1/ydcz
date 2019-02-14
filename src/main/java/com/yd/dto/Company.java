package com.yd.dto;

/**
 * Created by james on 2019/2/14.
 */
public class Company extends BaseDTO {
    private Integer id;
    private String name;
    private String isyx;

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
}

package com.yd.dto;

/**
 * Created by Administrator on 2019/4/3/003.
 */
public class Advert extends BaseDTO {
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

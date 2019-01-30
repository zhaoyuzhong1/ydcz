package com.yd.dto;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/19.
 */
public class Function extends BaseDTO {

    private int id;
    private String name;
    private int pid;
    private String url;
    private int order;
    private int cuser;
    private String flag;
    private Date cdate;
    private String iconcss;

    public String getIconcss() {
        return iconcss;
    }

    public void setIconcss(String iconcss) {
        this.iconcss = iconcss;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getCuser() {
        return cuser;
    }

    public void setCuser(int cuser) {
        this.cuser = cuser;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getCdate() {
        if(cdate != null){
            return (Date) cdate.clone();
        }
        return null;
    }

    public void setCdate(Date cdate) {
        if(cdate != null){
            this.cdate = (Date) cdate.clone();
        }else{
            this.cdate = null;
        }
    }

    @Override
    public boolean equals(Object arg0) {
        // TODO Auto-generated method stub
        Function p = (Function) arg0;
        return name.equals(p.name) ;
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        String str = name ;
        return str.hashCode();
    }
}

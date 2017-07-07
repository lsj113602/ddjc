package com.ddjc.entity;

import java.util.Date;

public class Warningdata {
    private String id;

    private Date receivetime;

    private String deletemark;

    private String receivedata;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public String getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(String deletemark) {
        this.deletemark = deletemark == null ? null : deletemark.trim();
    }

    public String getReceivedata() {
        return receivedata;
    }

    public void setReceivedata(String receivedata) {
        this.receivedata = receivedata == null ? null : receivedata.trim();
    }
}
package com.ddjc.entity;

import java.util.Date;

public class Devicebind {
    private String id;

    private String userid;

    private String deviceid;

    private Date bindtime;

    private Date unbindtime;

    private Byte isbind;

    private Byte deletemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public Date getBindtime() {
        return bindtime;
    }

    public void setBindtime(Date bindtime) {
        this.bindtime = bindtime;
    }

    public Date getUnbindtime() {
        return unbindtime;
    }

    public void setUnbindtime(Date unbindtime) {
        this.unbindtime = unbindtime;
    }

    public Byte getIsbind() {
        return isbind;
    }

    public void setIsbind(Byte isbind) {
        this.isbind = isbind;
    }

    public Byte getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(Byte deletemark) {
        this.deletemark = deletemark;
    }
}
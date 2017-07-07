package com.ddjc.entity;

public class Nurseuser {
    private String id;

    private String nurseid;

    private String userid;

    private String relationmark;

    private String logoid;

    private Byte deletemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNurseid() {
        return nurseid;
    }

    public void setNurseid(String nurseid) {
        this.nurseid = nurseid == null ? null : nurseid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRelationmark() {
        return relationmark;
    }

    public void setRelationmark(String relationmark) {
        this.relationmark = relationmark == null ? null : relationmark.trim();
    }

    public String getLogoid() {
        return logoid;
    }

    public void setLogoid(String logoid) {
        this.logoid = logoid == null ? null : logoid.trim();
    }

    public Byte getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(Byte deletemark) {
        this.deletemark = deletemark;
    }
}
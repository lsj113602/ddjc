package com.ddjc.entity;

public class Userfriend {
    private String id;

    private String userid;

    private String friendid;

    private String relationmark;

    private String logoid;

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

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid == null ? null : friendid.trim();
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
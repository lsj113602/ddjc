package com.ddjc.entity;

import java.util.Date;

public class Messages {
    private String id;

    private String userid;

    private String senduserid;

    private Integer messagetype;

    private String title;

    private Date sendtime;

    private Byte isread;

    private Byte deletemark;

    private String content;

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

    public String getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(String senduserid) {
        this.senduserid = senduserid == null ? null : senduserid.trim();
    }

    public Integer getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(Integer messagetype) {
        this.messagetype = messagetype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Byte getIsread() {
        return isread;
    }

    public void setIsread(Byte isread) {
        this.isread = isread;
    }

    public Byte getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(Byte deletemark) {
        this.deletemark = deletemark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
package com.ddjc.entity;

public class Appupdate {
    private String id;

    private Byte typeid;

    private String version;

    private String downloadurl;

    private Byte isforce;

    private Byte isprompt;

    private Byte deletemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getTypeid() {
        return typeid;
    }

    public void setTypeid(Byte typeid) {
        this.typeid = typeid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl == null ? null : downloadurl.trim();
    }

    public Byte getIsforce() {
        return isforce;
    }

    public void setIsforce(Byte isforce) {
        this.isforce = isforce;
    }

    public Byte getIsprompt() {
        return isprompt;
    }

    public void setIsprompt(Byte isprompt) {
        this.isprompt = isprompt;
    }

    public Byte getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(Byte deletemark) {
        this.deletemark = deletemark;
    }
}
package com.ddjc.entity;

public class Device {
    private String id;

    private String brandmodelid;

    private String categoryname;

    private String madeby;

    private String macaddress;

    private String remark;

    private Byte deletemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBrandmodelid() {
        return brandmodelid;
    }

    public void setBrandmodelid(String brandmodelid) {
        this.brandmodelid = brandmodelid == null ? null : brandmodelid.trim();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public String getMadeby() {
        return madeby;
    }

    public void setMadeby(String madeby) {
        this.madeby = madeby == null ? null : madeby.trim();
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress == null ? null : macaddress.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(Byte deletemark) {
        this.deletemark = deletemark;
    }
}
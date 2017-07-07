package com.ddjc.entity;

import java.util.Date;

public class User {
    private String id;

    private String username;

    private String usercode;

    private String userphone;

    private String useremail;

    private Byte isview;

    private String userjob;

    private String userlogo;

    private Date userbirthday;

    private Byte deletemark;

    private Byte usersex;

    private String userpassword;

    private Byte usertype;

    private String userqrcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public Byte getIsview() {
        return isview;
    }

    public void setIsview(Byte isview) {
        this.isview = isview;
    }

    public String getUserjob() {
        return userjob;
    }

    public void setUserjob(String userjob) {
        this.userjob = userjob == null ? null : userjob.trim();
    }

    public String getUserlogo() {
        return userlogo;
    }

    public void setUserlogo(String userlogo) {
        this.userlogo = userlogo == null ? null : userlogo.trim();
    }

    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    public Byte getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(Byte deletemark) {
        this.deletemark = deletemark;
    }

    public Byte getUsersex() {
        return usersex;
    }

    public void setUsersex(Byte usersex) {
        this.usersex = usersex;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public String getUserqrcode() {
        return userqrcode;
    }

    public void setUserqrcode(String userqrcode) {
        this.userqrcode = userqrcode == null ? null : userqrcode.trim();
    }
}
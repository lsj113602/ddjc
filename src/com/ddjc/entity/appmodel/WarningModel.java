package com.ddjc.entity.appmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WarningModel {
	private String id;
	private String userName;
	private String longitude;
	private String latitude;
	private String behavior;
	private Date receiveTime;
	private Byte source;
	private Byte isHandle;
	private String remarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getBehavior() {
		return behavior;
	}
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Byte getSource() {
		return source;
	}
	public void setSource(Byte source) {
		this.source = source;
	}
	public Byte getIsHandle() {
		return isHandle;
	}
	public void setIsHandle(Byte isHandle) {
		this.isHandle = isHandle;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

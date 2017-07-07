package com.ddjc.entity.appmodel;

public class registModel {
	private String id;
	private String userCode;
	private String userLogo;
	private Byte userType;  
	
	public Byte getUserType() {
		return userType;
	}
	public void setUserType(Byte userType) {
		this.userType = userType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserLogo() {
		return userLogo;
	}
	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}
}

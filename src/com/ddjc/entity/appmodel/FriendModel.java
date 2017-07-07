package com.ddjc.entity.appmodel;

public class FriendModel {
	private String id;
	private String userId;

	private String friendId;
	private String relationMark;
	private String fidLogoId;
	private String fidCode;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getRelationMark() {
		return relationMark;
	}
	public void setRelationMark(String relationMark) {
		this.relationMark = relationMark;
	}
	public String getFidLogoId() {
		return fidLogoId;
	}
	public void setFidLogoId(String fidLogoId) {
		this.fidLogoId = fidLogoId;
	}
	public String getFidCode() {
		return fidCode;
	}
	public void setFidCode(String fidCode) {
		this.fidCode = fidCode;
	}

}

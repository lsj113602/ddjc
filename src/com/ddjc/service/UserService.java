package com.ddjc.service;

import com.alibaba.fastjson.JSONObject;
import com.ddjc.entity.User;
import com.ddjc.entity.Userfeedback;

public interface UserService{
	public int insertUser(User user);

	public User login(String userCode, String userPassword);

	public User findUserById(String id);

	public User findUserBycode(String firendcode);

	public int updateUser(User user);

	public int insertFeedBack(Userfeedback userfeedback);

	JSONObject modifyPsw(String userCode, String oldPassword, String newPassword, String newPassword1);
}

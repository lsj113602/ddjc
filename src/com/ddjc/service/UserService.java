package com.ddjc.service;

import com.ddjc.entity.User;

public interface UserService{
	public int insertUser(User user);

	public User login(String userCode, String userPassword);

	public User findUserById(String id);

	public User findUserBycode(String firendcode);

	public void updateUser(User user);

}

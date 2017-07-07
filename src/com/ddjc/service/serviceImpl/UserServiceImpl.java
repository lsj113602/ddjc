package com.ddjc.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddjc.basic.service.Impl.BasicServiceImpl;
import com.ddjc.dao.UserMapper;
import com.ddjc.entity.User;
import com.ddjc.service.UserService;
@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;
	
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return usermapper.insert(user);
	}
	
	public User login(String userCode, String userPassword){
		User user=new User();
		user.setUsercode(userCode);
		user.setUserpassword(userPassword);
		return usermapper.login(user);
	}
	
	public User findUserById(String id){
		return usermapper.selectByPrimaryKey(id);
	}
	public User findUserBycode(String firendcode){
		return usermapper.findUserBycode(firendcode);
	}
}

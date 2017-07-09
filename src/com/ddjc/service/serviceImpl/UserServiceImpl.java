package com.ddjc.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.ddjc.dao.UserMapper;
import com.ddjc.dao.UserfeedbackMapper;
import com.ddjc.entity.User;
import com.ddjc.entity.Userfeedback;
import com.ddjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private UserfeedbackMapper userfeedbackMapper;

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

	@Override
	public int updateUser(User user) {
		return usermapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int insertFeedBack(Userfeedback userfeedback) {
		return userfeedbackMapper.insert(userfeedback);
	}

	@Override
	public JSONObject modifyPsw(String userCode, String oldPassword, String newPassword,String newPassword1) {
		User user = usermapper.findUserBycode(userCode);
		JSONObject json = new JSONObject();
		if (user == null) {
			json.put("code","2010");
			json.put("msg","’À∫≈≤ª¥Ê‘⁄");
		} else if (!newPassword.equals(newPassword1)) {
			json.put("code","2001");
			json.put("msg","¡Ω¥Œ√‹¬Î≤ª“ª÷¬");
		} else if (!user.getUserpassword().equals(oldPassword)){
			json.put("code","2011");
			json.put("msg","’À∫≈√‹¬Î≤ª∆•≈‰");
		}else {
			user.setUserpassword(newPassword);
			int i = usermapper.updateByPrimaryKey(user);
			if(i == 1){
				json.put("id",user.getId());
				json.put("userCode",user.getUsercode());
				json.put("userLogo",user.getUserlogo());
			}else{
				json.put("code",2002);
				json.put("msg","√‹¬Î–ﬁ∏ƒ ß∞‹");
			}
		}
		return json;
	}

	@Override
	public List<User> selectAll() {
		return usermapper.selectAll();
	}
}

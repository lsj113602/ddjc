package com.ddjc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddjc.dao.UserMapper;
import com.ddjc.dao.UserfriendMapper;
import com.ddjc.entity.User;
import com.ddjc.entity.Userfriend;
import com.ddjc.entity.appmodel.FriendModel;
import com.ddjc.service.UserfriendService;
import com.ddjc.utils.UuidUtil;
@Service("UserfriendService")
public class UserfriendServiceImpl implements UserfriendService{
	@Autowired
	private UserfriendMapper userfriendmapper;
	@Autowired
	private UserMapper usermapper;
	public Userfriend findByIds(String id, String id2){
		Userfriend userf=new Userfriend();
		userf.setUserid(id);
		userf.setFriendid(id2);
		return userfriendmapper.findByIds(userf);
	}
	public int insertFriend(String id, User user, String relationMark){
		Userfriend userfr=new Userfriend();
		userfr.setId(UuidUtil.getUuid());
		userfr.setFriendid(user.getId());
		userfr.setRelationmark(relationMark);
		userfr.setDeletemark((byte)0);
		userfr.setLogoid(user.getUserlogo());
		userfr.setUserid(id);
		int mark=userfriendmapper.insert(userfr);
		User user1=usermapper.selectByPrimaryKey(id);
		Userfriend userfr2=new Userfriend();
		userfr2.setId(UuidUtil.getUuid());
		userfr2.setUserid(user.getId());
		userfr2.setFriendid(id);
		userfr2.setLogoid(user1.getUserlogo());
		userfr2.setDeletemark((byte)0);
		int mark1=userfriendmapper.insert(userfr2);
		return mark+mark1;
	}
	
	public List<FriendModel> getMyFamilyList(String id){
		List<FriendModel> list=userfriendmapper.getMyFamilyList(id);
		return list;
	}
}

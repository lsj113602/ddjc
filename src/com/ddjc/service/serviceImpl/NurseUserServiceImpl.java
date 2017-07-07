package com.ddjc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddjc.dao.NurseuserMapper;
import com.ddjc.dao.UserMapper;
import com.ddjc.entity.*;
import com.ddjc.entity.appmodel.FriendModel;
import com.ddjc.service.NurseUserService;
import com.ddjc.utils.UuidUtil;
@Service("NurseUserService")
public class NurseUserServiceImpl implements NurseUserService{
	@Autowired
	private NurseuserMapper nurseusermapper;
	@Autowired
	private UserMapper usermapper;
	public int findByIdAndUsercode(String id, String firendcode,String mark){
		User user=usermapper.findUserBycode(firendcode);
		if(user==null){
			return 0;
		}else{
			if(id.equals(user.getId())){
				return 3;
			}
			Nurseuser nur=new Nurseuser();
			nur.setNurseid(id);
			nur.setUserid(user.getId());
			Nurseuser nurse=nurseusermapper.findByIdAndUsercode(nur);
			if(nurse!=null){
				return 2;
			}else{
    			Nurseuser nurseuser=new Nurseuser();
    			nurseuser.setId(UuidUtil.getUuid());
    			nurseuser.setDeletemark((byte)0);
    			nurseuser.setNurseid(id);
    			nurseuser.setUserid(user.getId());
    			nurseuser.setRelationmark(mark);
    			nurseuser.setLogoid(user.getUserlogo());
    			nurseusermapper.insert(nurseuser);
				return 1;
			}
		}
		
	}
	public List<FriendModel> getMyFamilyList(String id){
		List<FriendModel> list=nurseusermapper.getMyFamilyList(id);
		return list;
	}
}

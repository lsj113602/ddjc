package com.ddjc.service;

import java.util.List;

import com.ddjc.entity.appmodel.FriendModel;


public interface NurseUserService {

	int findByIdAndUsercode(String id, String firendcode,String mark);

	List<FriendModel> getMyFamilyList(String id);

}

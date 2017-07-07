package com.ddjc.service;

import java.util.List;

import com.ddjc.entity.User;
import com.ddjc.entity.Userfriend;
import com.ddjc.entity.appmodel.FriendModel;

public interface UserfriendService {

	Userfriend findByIds(String id, String id2);

	int insertFriend(String id, User user, String relationMark);

	List<FriendModel> getMyFamilyList(String id);

}

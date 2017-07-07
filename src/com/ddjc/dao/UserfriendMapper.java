package com.ddjc.dao;

import java.util.List;

import com.ddjc.entity.Userfriend;
import com.ddjc.entity.appmodel.FriendModel;

public interface UserfriendMapper {
    int deleteByPrimaryKey(String id);

    int insert(Userfriend record);

    int insertSelective(Userfriend record);

    Userfriend selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userfriend record);

    int updateByPrimaryKey(Userfriend record);

	Userfriend findByIds(Userfriend userf);

	List<FriendModel> getMyFamilyList(String userid);
}
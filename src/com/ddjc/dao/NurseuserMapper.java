package com.ddjc.dao;

import java.util.List;

import com.ddjc.entity.Nurseuser;
import com.ddjc.entity.appmodel.FriendModel;

public interface NurseuserMapper {
    int deleteByPrimaryKey(String id);

    int insert(Nurseuser record);

    int insertSelective(Nurseuser record);

    Nurseuser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Nurseuser record);

    int updateByPrimaryKey(Nurseuser record);

	Nurseuser findByIdAndUsercode(Nurseuser record);

	List<FriendModel> getMyFamilyList(String userid);
}
package com.ddjc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ddjc.entity.Messages;
import com.ddjc.entity.appmodel.MessagesModel;

public interface MessagesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Messages record);

    int insertSelective(Messages record);

    Messages selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Messages record);

    int updateByPrimaryKeyWithBLOBs(Messages record);

    int updateByPrimaryKey(Messages record);

	List<MessagesModel> getMessage(@Param("id")String id, @Param("type")int type, @Param("state")int state);

	int readMessage(@Param("id")String id);
}
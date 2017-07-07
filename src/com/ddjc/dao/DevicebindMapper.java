package com.ddjc.dao;

import com.ddjc.entity.Devicebind;

public interface DevicebindMapper {
    int deleteByPrimaryKey(String id);

    int insert(Devicebind record);

    int insertSelective(Devicebind record);

    Devicebind selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Devicebind record);

    int updateByPrimaryKey(Devicebind record);
}
package com.ddjc.dao;

import com.ddjc.entity.Devicedata;
import com.ddjc.entity.DevicedataWithBLOBs;

public interface DevicedataMapper {
    int deleteByPrimaryKey(String id);

    int insert(DevicedataWithBLOBs record);

    int insertSelective(DevicedataWithBLOBs record);

    DevicedataWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DevicedataWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DevicedataWithBLOBs record);

    int updateByPrimaryKey(Devicedata record);
}
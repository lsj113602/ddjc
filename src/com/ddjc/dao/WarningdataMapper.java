package com.ddjc.dao;

import com.ddjc.entity.Warningdata;

public interface WarningdataMapper {
    int deleteByPrimaryKey(String id);

    int insert(Warningdata record);

    int insertSelective(Warningdata record);

    Warningdata selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Warningdata record);

    int updateByPrimaryKeyWithBLOBs(Warningdata record);

    int updateByPrimaryKey(Warningdata record);
}
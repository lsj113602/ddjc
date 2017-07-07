package com.ddjc.dao;

import com.ddjc.entity.Databracelet;

public interface DatabraceletMapper {
    int deleteByPrimaryKey(String id);

    int insert(Databracelet record);

    int insertSelective(Databracelet record);

    Databracelet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Databracelet record);

    int updateByPrimaryKey(Databracelet record);
}
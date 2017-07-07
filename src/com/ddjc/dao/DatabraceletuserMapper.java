package com.ddjc.dao;

import com.ddjc.entity.Databraceletuser;

public interface DatabraceletuserMapper {
    int deleteByPrimaryKey(String id);

    int insert(Databraceletuser record);

    int insertSelective(Databraceletuser record);

    Databraceletuser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Databraceletuser record);

    int updateByPrimaryKey(Databraceletuser record);
}
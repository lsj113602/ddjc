package com.ddjc.dao;

import com.ddjc.entity.Ratio;

import java.util.List;

public interface RatioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ratio record);

    int insertSelective(Ratio record);

    Ratio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ratio record);

    int updateByPrimaryKey(Ratio record);

    List<Ratio> selectLastRow();
}
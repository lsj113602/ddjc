package com.ddjc.dao;

import com.ddjc.entity.Appupdate;

public interface AppupdateMapper {
    int insert(Appupdate record);

    int insertSelective(Appupdate record);
}
package com.ddjc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ddjc.entity.Warninguntreated;
import com.ddjc.entity.appmodel.WarningModel;

public interface WarninguntreatedMapper {
    int deleteByPrimaryKey(String id);

    int insert(Warninguntreated record);

    int insertSelective(Warninguntreated record);

    Warninguntreated selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Warninguntreated record);

    int updateByPrimaryKey(Warninguntreated record);

	List<WarningModel> findWarningByNurse(@Param("id")String id);

	List<WarningModel> findWarningByUser(@Param("id")String id);

	int deleteBywarnId(@Param("id")String id);

	int updateRemarks(@Param("id")String id, @Param("remarks")String remarks);
}
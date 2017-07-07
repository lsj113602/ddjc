package com.ddjc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ddjc.entity.Warningmove;
import com.ddjc.entity.appmodel.WarningModel;

public interface WarningmoveMapper {
    int deleteByPrimaryKey(String id);

    int insert(Warningmove record);

    int insertSelective(Warningmove record);

    Warningmove selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Warningmove record);

    int updateByPrimaryKey(Warningmove record);

	List<WarningModel> findWarningByNurseAll(@Param("id")String id);

	List<WarningModel> findWarningByNurseOk(@Param("id")String id);

	List<WarningModel> findWarningByUserAll(@Param("id")String id);

	List<WarningModel> findWarningByUserOk(@Param("id")String id);
}
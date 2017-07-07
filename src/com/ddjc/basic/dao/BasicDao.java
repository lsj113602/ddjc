package com.ddjc.basic.dao;


public interface BasicDao<T> {
	int deleteByPrimaryKey(String refrenceid);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String refrenceid);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}

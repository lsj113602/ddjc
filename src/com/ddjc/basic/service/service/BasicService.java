package com.ddjc.basic.service.service;

public interface BasicService<T> {
	int deleteByPrimaryKey(String refrenceid);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String refrenceid);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}

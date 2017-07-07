package com.ddjc.basic.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddjc.basic.dao.BasicDao;
import com.ddjc.basic.service.service.BasicService;


public class BasicServiceImpl<T> implements BasicService<T>{
	@Autowired
	private BasicDao<T>dao;
	
	public BasicServiceImpl(BasicDao dao){
		this.dao=dao;
	}
	public BasicServiceImpl(){
		
	}
	@Override
	public int deleteByPrimaryKey(String refrenceid) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(refrenceid);
	}

	@Override
	public int insert(T record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(String refrenceid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(refrenceid);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

}

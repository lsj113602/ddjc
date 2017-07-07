package com.ddjc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddjc.dao.MessagesMapper;
import com.ddjc.entity.appmodel.MessagesModel;
import com.ddjc.service.CommonService;
@Service("CommonService")
public class CommonServiceImpl implements CommonService{
	@Autowired
	private MessagesMapper messagesmapper;
	
	public List<MessagesModel> getMessage(String id, String type1, String state1){
		int state=Integer.parseInt(state1);
		int type=Integer.parseInt(type1);
		return messagesmapper.getMessage(id,type,state);		
	}
	
	public int readMessage(String id, String uid){
		return messagesmapper.readMessage(id);
	}

}

package com.ddjc.service.serviceImpl;

import com.ddjc.dao.AppupdateMapper;
import com.ddjc.dao.MessagesMapper;
import com.ddjc.entity.Appupdate;
import com.ddjc.entity.appmodel.MessagesModel;
import com.ddjc.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CommonService")
public class CommonServiceImpl implements CommonService{
	@Autowired
	private MessagesMapper messagesmapper;

	@Autowired
	private AppupdateMapper appupdateMapper;

	public List<MessagesModel> getMessage(String id, String type1, String state1){
		int state=Integer.parseInt(state1);
		int type=Integer.parseInt(type1);
		return messagesmapper.getMessage(id,type,state);		
	}
	
	public int readMessage(String id, String uid){
		return messagesmapper.readMessage(id);
	}

	@Override
	public Appupdate getLatestVersion(int type) {
		return appupdateMapper.selectLatestRawByType(type);
	}

}

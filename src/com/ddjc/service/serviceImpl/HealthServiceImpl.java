package com.ddjc.service.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddjc.dao.MessagesMapper;
import com.ddjc.entity.Messages;
import com.ddjc.service.HealthService;
import com.ddjc.utils.UuidUtil;
@Service("HealthService")
public class HealthServiceImpl implements HealthService{
	@Autowired
	private MessagesMapper messagesmapper;
	public int sendMessage(String id, String uid, String title, String content){
		Messages message=new Messages();
		message.setId(UuidUtil.getUuid());
		message.setMessagetype(1);
		message.setTitle(title);
		message.setUserid(uid);
		message.setSendtime(new Date());
		message.setSenduserid(id);
		message.setIsread((byte)0);
		message.setContent(content);
		message.setDeletemark((byte)0);
		return messagesmapper.insert(message);
	}
}

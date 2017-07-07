package com.ddjc.service;

import java.util.List;

import com.ddjc.entity.appmodel.MessagesModel;

public interface CommonService {

	List<MessagesModel> getMessage(String id, String type, String state);

	int readMessage(String id, String uid);

}

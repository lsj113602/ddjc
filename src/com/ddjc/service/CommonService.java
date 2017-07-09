package com.ddjc.service;

import com.ddjc.entity.Appupdate;
import com.ddjc.entity.appmodel.MessagesModel;

import java.util.List;

public interface CommonService {

	List<MessagesModel> getMessage(String id, String type, String state);

	int readMessage(String id, String uid);

	Appupdate getLatestVersion(int type);
}

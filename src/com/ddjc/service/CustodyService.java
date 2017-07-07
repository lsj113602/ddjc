package com.ddjc.service;

import java.util.List;

import com.ddjc.entity.appmodel.WarningModel;

public interface CustodyService {

	int addWarning(String id, String longitude, String latitude,
			String behavior, String receiveTime, String behaviorData);

	List<WarningModel> getWarning(String id, int state,String userType);

	int doWarning(String id, String uid, int state, String remarks);

}

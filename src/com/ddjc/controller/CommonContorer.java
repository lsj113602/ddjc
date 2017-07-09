package com.ddjc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddjc.entity.Appupdate;
import com.ddjc.entity.appmodel.MessagesModel;
import com.ddjc.json.AppJsonMessage;
import com.ddjc.service.CommonService;
import com.ddjc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonContorer {
    private static final int VERSION_ANDROID = 0;
    private static final int VERSION_IOS = 1;

	@Autowired
	private CommonService commonservice;
	
	@ResponseBody
    @RequestMapping(value = "/getMessage")
	public AppJsonMessage getMessage(String data){	
    	AppJsonMessage app=new AppJsonMessage();
    	JSONObject jsonObj = JSON.parseObject(data);
    	String id=jsonObj.getString("id");
    	String type=jsonObj.getString("type");
    	String state=jsonObj.getString("state");
    	List<MessagesModel> list=commonservice.getMessage(id,type,state);
        app.setCode(0);
        app.setMsg("�����ɹ�");
        app.setData(list);   ////    
        return app;
	}
	
	@ResponseBody
    @RequestMapping(value = "/readMessage")
	public AppJsonMessage readMessage(String data){	
    	AppJsonMessage app=new AppJsonMessage();
    	JSONObject jsonObj = JSON.parseObject(data);
    	String id=jsonObj.getString("id");
    	String uid=jsonObj.getString("uid");
    	int mark=commonservice.readMessage(id,uid);
    	if(mark>0){
            app.setCode(0);
            app.setMsg("�����ɹ�");
            app.setData("");
    	}
    	else{
    		app.setCode(1008);
            app.setMsg("����ʧ��");
            app.setData("");
    	}
        return app;
	}

	@ResponseBody
	@RequestMapping(value = "/getLatestVersion")
	public AppJsonMessage getLatestVersion(String data){
		AppJsonMessage app=new AppJsonMessage();
		JSONObject jsonObj = JSON.parseObject(data);
        int type = jsonObj.getIntValue("type");
        Appupdate latestVersion = commonservice.getLatestVersion(type);
        if(latestVersion != null){
            return ResultUtil.success(latestVersion);
        }else {
            return ResultUtil.failed(1001,"����������");
        }
	}
}

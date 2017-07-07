package com.ddjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddjc.entity.appmodel.MessagesModel;
import com.ddjc.json.AppJsonMessage;
import com.ddjc.service.CommonService;

@Controller
@RequestMapping("/common")
public class CommonContorer {
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
        app.setMsg("操作成功");
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
            app.setMsg("操作成功");
            app.setData("");
    	}
    	else{
    		app.setCode(1008);
            app.setMsg("操作失败");
            app.setData("");
    	}
        return app;
	}
}

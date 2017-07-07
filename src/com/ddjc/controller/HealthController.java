package com.ddjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddjc.entity.User;
import com.ddjc.entity.appmodel.registModel;
import com.ddjc.json.AppJsonMessage;
import com.ddjc.service.HealthService;

@Controller
@RequestMapping("/health")
public class HealthController {
	@Autowired
	private HealthService healthservice;
	
	@ResponseBody
    @RequestMapping(value = "/healthAdvice")
	public AppJsonMessage healthAdvice(String data){	
    	AppJsonMessage app=new AppJsonMessage();
    	JSONObject jsonObj = JSON.parseObject(data);
    	String id=jsonObj.getString("id");
    	String uid=jsonObj.getString("uid");
    	String title=jsonObj.getString("title");
    	String content=jsonObj.getString("content");
    	int mark=healthservice.sendMessage(id,uid,title,content);
        if(mark>0){
        	app.setCode(0);
        	app.setMsg("操作成功");
        	app.setData("");        	
        	
        }else{        	
        	app.setCode(3061);
        	app.setMsg("操作失败");
        	app.setData("");        	
        }
        return app;
	}
}

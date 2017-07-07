package com.ddjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddjc.entity.User;
import com.ddjc.entity.appmodel.WarningModel;
import com.ddjc.entity.appmodel.registModel;
import com.ddjc.json.AppJsonMessage;
import com.ddjc.service.CustodyService;

@Controller
@RequestMapping("/custody")
public class CustodyController {
	    @Autowired
	    private CustodyService custodyservice;
	
	
	    @ResponseBody
	    @RequestMapping(value = "/sendWarning")
		public AppJsonMessage sendWarning(String data){	
	    	AppJsonMessage app=new AppJsonMessage();
	    	JSONObject jsonObj = JSON.parseObject(data);
	    	String id=jsonObj.getString("id");
	    	String longitude=jsonObj.getString("longitude");
	    	String latitude=jsonObj.getString("latitude");
	    	String behavior=jsonObj.getString("behavior");
	    	String receiveTime=jsonObj.getString("receiveTime");
	    	String behaviorData=jsonObj.getString("behaviorData");
	    	int mark=custodyservice.addWarning(id,longitude,latitude,behavior,receiveTime,behaviorData);
	        if(mark>0){
	        	app.setCode(0);
		        app.setMsg("发送成功");
		        app.setData("");  
	        }else{
	        	app.setCode(3071);
		        app.setMsg("操作失败");
		        app.setData("");  
	        }	        	            	
	        return app;
	}	 
	    @ResponseBody
	    @RequestMapping(value = "/getWarning")
		public AppJsonMessage getWarning(String data){	
	    	AppJsonMessage app=new AppJsonMessage();
	    	JSONObject jsonObj = JSON.parseObject(data);
	    	String id=jsonObj.getString("id");
	    	String stat=jsonObj.getString("state");
	    	String userType=jsonObj.getString("userType");
	    	int state=Integer.parseInt(stat);
	    	List<WarningModel> list=custodyservice.getWarning(id,state,userType);	        
	        app.setCode(0);
		    app.setMsg("操作成功");
		    app.setData(list);         	            	
	        return app;
	}
	    @ResponseBody
	    @RequestMapping(value = "/doWarning")
		public AppJsonMessage doWarning(String data){	
	    	AppJsonMessage app=new AppJsonMessage();
	    	JSONObject jsonObj = JSON.parseObject(data);
	    	String id=jsonObj.getString("id");
	    	String uid=jsonObj.getString("uid");
	    	String sta=jsonObj.getString("state");
	    	String remarks=jsonObj.getString("remarks");
	    	int state=Integer.parseInt(sta);
	    	
	    	int mark=custodyservice.doWarning(id,uid,state,remarks);
	    	if(mark>0){
	    		app.setCode(0);
			    app.setMsg("操作成功");
			    app.setData("");  
	    	}else{
	    		app.setCode(3081);
			    app.setMsg("操作失败，该信息已不存在");
			    app.setData(""); 
	    	}
	               	            	
	        return app;
	}
}

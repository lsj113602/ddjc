package com.ddjc.service.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddjc.dao.*;
import com.ddjc.entity.*;
import com.ddjc.entity.appmodel.WarningModel;
import com.ddjc.service.CustodyService;
import com.ddjc.utils.UuidUtil;

@Service("CustodyService")
public class CustodyServiceImpl implements CustodyService{
	@Autowired
	private WarningdataMapper warningdatamapper;
	@Autowired
	private WarningmoveMapper warningmovemapper;
	@Autowired
	private WarninguntreatedMapper warninguntreatedmapper;
	
	public int doWarning(String id, String uid, int state, String remarks){
		Warningmove warning=warningmovemapper.selectByPrimaryKey(id);
		if(warning==null){
			return 0;
		}
		warning.setRemarks(remarks);
		warning.setIshandle((byte)state);
		warningmovemapper.updateByPrimaryKeySelective(warning);
		if(state==1){
			return warninguntreatedmapper.deleteBywarnId(id);
		}else{
			return warninguntreatedmapper.updateRemarks(id,remarks);
		}
	}
	
	public List<WarningModel> getWarning(String id, int state,String userType){
		List<WarningModel> list=null;
		if(userType.equals("1")){
			if(state==0){
				list=warninguntreatedmapper.findWarningByNurse(id);
				for(int i=0;i<list.size();i++){
					list.get(i).setIsHandle((byte)0);
				}
			}else if(state==1){
				list=warningmovemapper.findWarningByNurseAll(id);
			}else{
				list=warningmovemapper.findWarningByNurseOk(id);
			}
		}else{
		/*	if(state==0){
				list=warninguntreatedmapper.findWarningByUser(id);
				for(int i=0;i<list.size();i++){
					list.get(i).setIsHandle((byte)0);
				}
			}else if(state==1){
				list=warningmovemapper.findWarningByUserAll(id);
			}else{
				list=warningmovemapper.findWarningByUserOk(id);
			}*/
			list=warningmovemapper.findWarningByUserAll(id);
		}
		
		return list;
	}
	public int addWarning(String id, String longitude, String latitude,
			String behavior, String receiveTime, String behaviorData){
		Warningdata warningdata=new Warningdata();
		warningdata.setDeletemark("0");
		warningdata.setId(UuidUtil.getUuid());
		warningdata.setReceivedata(behaviorData);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = null;
		try {
			date = sdf.parse(receiveTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return 0;
			//e.printStackTrace();
		}  
		warningdata.setReceivetime(date);
		warningdatamapper.insert(warningdata);
		String uuid=UuidUtil.getUuid();
		
		Warningmove warningmove=new Warningmove();
		warningmove.setId(uuid);
		warningmove.setBehavior(behavior);
		warningmove.setDeletemark((byte)0);
		warningmove.setUserid(id);
		warningmove.setLongitude(longitude);
		warningmove.setLatitude(latitude);
		warningmove.setIshandle((byte)0);
		warningmove.setReceivetime(date);	
		warningmove.setSource((byte)0);
		warningmovemapper.insert(warningmove);
		
		Warninguntreated warning=new Warninguntreated();
		warning.setId(UuidUtil.getUuid());
		warning.setBehavior(behavior);
		warning.setReceivetime(date);
		warning.setLatitude(latitude);
		warning.setLongitude(longitude);
		warning.setUserid(id);
		warning.setSource((byte)0);
		warning.setWarningid(uuid);
		warninguntreatedmapper.insert(warning);
		return 1;
	}

}

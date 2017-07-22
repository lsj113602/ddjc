package com.ddjc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddjc.entity.User;
import com.ddjc.entity.Userfriend;
import com.ddjc.entity.appmodel.FriendModel;
import com.ddjc.json.AppJsonMessage;
import com.ddjc.service.NurseUserService;
import com.ddjc.service.UserService;
import com.ddjc.service.UserfriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/carelove")
public class CareloveController {

    @Autowired
    private NurseUserService nurseuserservice;
    @Autowired
    private UserService userservice;
    @Autowired
    private UserfriendService userfriendservice;

    @ResponseBody
    @RequestMapping(value = "/addFamily")
    public AppJsonMessage addFamily(String data) {
        AppJsonMessage app = new AppJsonMessage();
        JSONObject jsonObj = JSON.parseObject(data);
        String id = jsonObj.getString("id");
        String userType = jsonObj.getString("userType");
        String firendcode = jsonObj.getString("firendcode");
        String relationMark = jsonObj.getString("relationMark");

        User user = userservice.findUserBycode(firendcode);
        if (user == null) {
            app.setCode(4021);
            app.setMsg("该亲友不存在");
            app.setData("");
            return app;
        }
        if (user.getId().equals(id)) {
            app.setCode(4023);
            app.setMsg("添加失败，不能添加自己");
            app.setData("");
            return app;
        }
        if (userType.equals("1")) {
            int unrse = nurseuserservice.findByIdAndUsercode(id, firendcode, relationMark);
            if (unrse == 2) {
                app.setCode(4024);
                app.setMsg("您已添加该好友，无须重复添加");
                app.setData("");
                return app;
            } else {
                app.setCode(0);
                app.setMsg("添加成功");
                app.setData("");
                return app;
            }
        } else {
            Userfriend userfriend = userfriendservice.findByIds(id, user.getId());
            if (userfriend != null) {
                app.setCode(4024);
                app.setMsg("您已添加该好友，无须重复添加");
                app.setData("");
            } else {

                int mark = userfriendservice.insertFriend(id, user, relationMark);
                if (mark > 1) {
                    app.setCode(0);
                    app.setMsg("添加成功");
                    app.setData("");
                }

            }
            return app;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/getMyFamilyList")
    public AppJsonMessage getMyFamilyList(String data) {
        AppJsonMessage app = new AppJsonMessage();
        JSONObject jsonObj = JSON.parseObject(data);
        String id = jsonObj.getString("id");
        String userType = jsonObj.getString("userType");
        List<FriendModel> friendList = null;
        if (userType.equals("1")) {
            friendList = nurseuserservice.getMyFamilyList(id);
        } else {
            friendList = userfriendservice.getMyFamilyList(id);
        }
        app.setCode(0);
        app.setMsg("操作成功");
        app.setData(friendList);
        return app;
    }
}

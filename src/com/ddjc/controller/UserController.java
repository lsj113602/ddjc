package com.ddjc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddjc.basic.HttpRequestTool;
import com.ddjc.basic.QrcodeTool;
import com.ddjc.entity.User;
import com.ddjc.entity.appmodel.QrcodeModel;
import com.ddjc.entity.appmodel.registModel;
import com.ddjc.json.AppJsonMessage;
import com.ddjc.service.UserService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Controller
@RequestMapping("/user")
public class UserController {
    //@Autowired
//	private static HttpServletRequest requestHttp;
    //@Autowired
    private HttpRequestTool httprequest = new HttpRequestTool();
    QrcodeTool tool = new QrcodeTool();

    @Autowired
    private UserService userservice;


    /**
     * 登录
     *
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public AppJsonMessage LoginServlet(String data) {
        //	ServletActionContext.getRequest().getSession().setAttribute("sessionUser", user);
        AppJsonMessage app = new AppJsonMessage();
        JSONObject jsonObj = JSON.parseObject(data);
        String userCode = jsonObj.getString("userCode");
        String userPassword = jsonObj.getString("userPassword");
        User user = userservice.login(userCode, userPassword);
        if (user == null) {
            app.setCode(2011);
            app.setMsg("账号密码不匹配");
            app.setData("");
            return app;
        } else {
            registModel model = new registModel();
            model.setId(user.getId());
            model.setUserCode(user.getUsercode());
            model.setUserLogo(user.getUserlogo());
            model.setUserType(user.getUsertype());
            app.setCode(0);
            app.setMsg("操作成功");
            app.setData(model);
            return app;
        }

    }

    /**
     * 注册
     *
     * @param session
     * @param data
     * @return
     * @throws IOException
     * @throws WriterException
     */
    @ResponseBody
    @RequestMapping(value = "/register")
    public AppJsonMessage Register(String data, HttpSession session) throws WriterException, IOException {
        String path = session.getServletContext().getRealPath("/");
        AppJsonMessage app = new AppJsonMessage();
        JSONObject jsonObj = JSON.parseObject(data);
        //Object param = JSON.parseObject(data, Object.class);
        //String code=jsonObj.getJSONArray("selList");
        String userCode = jsonObj.getString("userCode");
        String userPassword = jsonObj.getString("userPassword");
        String userPassword1 = jsonObj.getString("userPassword1");
        if (!userPassword.equals(userPassword1)) {
            app.setCode(2001);
            app.setMsg("两次密码不一样");
            app.setData("");
            return app;
        }
        String p = "op=getSMSToken&data={'phone':'" + userCode + "','type':0}";
        String result = httprequest.sendGet("http://yl.jsj.ccsu.cn:10005/AppInterface/Common.ashx", p);
        String p1 = "op=register&data={'phone':'" + userCode + "','code':'111111','pwd':'" + userPassword + "','inviteCode':'88888'}";
        String result1 = httprequest.sendGet("http://yl.jsj.ccsu.cn:10005/AppInterface/Common.ashx", p1);
        AppJsonMessage message = JSON.parseObject(result1, AppJsonMessage.class);
        int returncode = message.getCode();
        if (returncode == 2013) {
            app.setCode(2000);
            app.setMsg("该账号已经存在");
            app.setData("");
            return app;
        }
        String object = message.getData().toString();
        JSONObject jsonobject = JSON.parseObject(object);
        String id = jsonobject.getString("uid");
        User user = new User();
        user.setId(id);
        user.setUsercode(userCode);
        user.setUserpassword(userPassword);
        user.setUserphone(userCode);
        user.setUsertype((byte) 0);
        String qrpath = tool.toBufferedImage(path, id + ".png", userCode, 150, 150);
        user.setUserqrcode(qrpath);
        //user.setUserQrcode();
        int num = userservice.insertUser(user);
        if (num > 0) {
            app.setCode(0);
            app.setMsg("操作成功");
            registModel model = new registModel();
            model.setId(id);
            model.setUserCode(userCode);
            model.setUserLogo("");
            model.setUserType((byte) 0);
            app.setData(model);
        }
        return app;
    }

    @ResponseBody
    @RequestMapping(value = "/getQrcode")
    public AppJsonMessage getQrcode(String data) {
        //	ServletActionContext.getRequest().getSession().setAttribute("sessionUser", user);
        AppJsonMessage app = new AppJsonMessage();
        InputStream in = this.getClass().getResourceAsStream("/System.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String FlieUrl = prop.getProperty("qrcodeUrl");
        JSONObject jsonObj = JSON.parseObject(data);
        String id = jsonObj.getString("id");
        User user = userservice.findUserById(id);
        if (user == null) {
            app.setCode(2070);
            app.setMsg("获取失败");
            app.setData("");
            return app;
        } else {
            QrcodeModel model = new QrcodeModel();
            model.setId(user.getId());
            model.setQrPath(FlieUrl + user.getUserqrcode());
            app.setCode(0);
            app.setMsg("操作成功");
            app.setData(model);
            return app;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/qrcode")
    public AppJsonMessage Qrcode(HttpSession session, String data) throws WriterException, IOException {
        //	ServletActionContext.getRequest().getSession().setAttribute("sessionUser", user);
        AppJsonMessage app = new AppJsonMessage();
        String path = session.getServletContext().getRealPath("/");
        QrcodeTool tool = new QrcodeTool();
        String qrpath = tool.toBufferedImage(path, "123.png", "lsj11111", 100, 100);
        app.setCode(0);
        app.setMsg("操作成功");
        app.setData(qrpath);
        return app;
    }

    @ResponseBody
    @RequestMapping(value = "/getInfo")
    public AppJsonMessage getInfo(String data) {
        AppJsonMessage app = new AppJsonMessage();
        JSONObject json = JSONObject.parseObject(data);

        String id = json.getString("id");
        User user = userservice.findUserById(id);
        if (user != null) {
            app.setData(user);
            app.setCode(0);
            app.setMsg(null);
        } else {
            app.setData("");
            app.setCode(2030);
            app.setMsg("获取信息失败");
        }
        return app;
    }

    @ResponseBody
    @RequestMapping(value = "/modifyInfo")
    public AppJsonMessage modifyInfo(String data) {
        AppJsonMessage app = new AppJsonMessage();
        JSONObject json = JSONObject.parseObject(data);
        User user = new User();
        user.setId(json.getString("id"));
        user.setUsername(json.getString("userName"));
        user.setUserphone(json.getString("userPhone"));
        user.setUserlogo(json.getString("userLogo"));
        user.setUseremail(json.getString("userEmail"));
        user.setIsview(json.getByte("isView"));
        user.setUserjob(json.getString("userJob"));
        user.setUserbirthday(json.getDate("userBirthday"));
        user.setUsersex(json.getByte("usersex"));
        userservice.updateUser(user);
        app.setMsg("操作成功");
        app.setCode(0);
        app.setData("");
        return app;
    }

    @ResponseBody
    @RequestMapping("/feedBack")
    public AppJsonMessage feedBack(String data){
        AppJsonMessage app  = new AppJsonMessage();
        JSONObject json = JSONObject.parseObject(data);
        String id = json.getString("id");
        String note = json.getString("note");
        String ext = json.getString("ext");

        return app;
    }
}

package com.ddjc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddjc.basic.HttpRequestTool;
import com.ddjc.basic.QrcodeTool;
import com.ddjc.entity.User;
import com.ddjc.entity.Userfeedback;
import com.ddjc.entity.appmodel.QrcodeModel;
import com.ddjc.entity.appmodel.registModel;
import com.ddjc.json.AppJsonMessage;
import com.ddjc.service.UserService;
import com.ddjc.utils.ResultUtil;
import com.google.zxing.WriterException;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
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
     * ��¼
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
            app.setMsg("�˺����벻ƥ��");
            app.setData("");
            return app;
        } else {
            registModel model = new registModel();
            model.setId(user.getId());
            model.setUserCode(user.getUsercode());
            model.setUserLogo(user.getUserlogo());
            model.setUserType(user.getUsertype());
            app.setCode(0);
            app.setMsg("�����ɹ�");
            app.setData(model);
            return app;
        }

    }

    /**
     * �ķ���
     * @return
     */
    @ResponseBody
    @RequestMapping("/createQrCode")
    public AppJsonMessage createQrCode(String data) throws IOException, WriterException {
        List<User> list = userservice.selectAll();
        QrcodeTool tool = new QrcodeTool();
        String path = "F:\\uploads\\qrcode\\";
        for (User user: list){
            String qrpath = tool.toBufferedImage(path, user.getId() + ".png", user.getUsercode(), 150, 150);
            user.setUserqrcode(qrpath);
            userservice.updateUser(user);
        }
        return new AppJsonMessage();
    }
    /**
     * ע��
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
//        String path = session.getServletContext().getRealPath("/");
        String path = "F:\\uploads\\qrcode\\";

        AppJsonMessage app = new AppJsonMessage();
        JSONObject jsonObj = JSON.parseObject(data);
        //Object param = JSON.parseObject(data, Object.class);
        //String code=jsonObj.getJSONArray("selList");
        String userCode = jsonObj.getString("userCode");
        String userPassword = jsonObj.getString("userPassword");
        String userPassword1 = jsonObj.getString("userPassword1");
        if (!userPassword.equals(userPassword1)) {
            app.setCode(2001);
            app.setMsg("�������벻һ��");
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
            app.setMsg("���˺��Ѿ�����");
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
            app.setMsg("�����ɹ�");
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
            return ResultUtil.failed(2070, "��ȡʧ��");
        } else {
            QrcodeModel model = new QrcodeModel();
            model.setId(user.getId());
            model.setQrPath(FlieUrl + user.getUserqrcode());
            return ResultUtil.success(model);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/qrcode")
    public AppJsonMessage Qrcode(HttpSession session, String data) throws WriterException, IOException {
        //	ServletActionContext.getRequest().getSession().setAttribute("sessionUser", user);

        String path = session.getServletContext().getRealPath("/");
        AppJsonMessage app = new AppJsonMessage();
        QrcodeTool tool = new QrcodeTool();
        String qrpath = tool.toBufferedImage(path, "123.png", "lsj11111", 100, 100);
        app.setCode(0);
        app.setMsg("�����ɹ�");
        app.setData(qrpath);
        return app;
    }

    @ResponseBody
    @RequestMapping(value = "/getInfo")
    public AppJsonMessage getInfo(String data) {

        JSONObject json = JSONObject.parseObject(data);
        String id = json.getString("id");
        User user = userservice.findUserById(id);
        if (user != null) {
            return ResultUtil.success(user);
        } else {

            return ResultUtil.failed(2030, "��ȡ��Ϣʧ��");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/modifyInfo")
    public AppJsonMessage modifyInfo(String data) {
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
        if (userservice.updateUser(user) == 1) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failed(2050, "�޸�����ʧ��");
        }
    }

    @ResponseBody
    @RequestMapping("/feedBack")
    public AppJsonMessage feedBack(String data) {
        JSONObject json = JSONObject.parseObject(data);
        String id = json.getString("id");
        String note = json.getString("note");
        String ext = json.getString("ext");
        Userfeedback userfeedback = new Userfeedback();
        userfeedback.setId(id);
        userfeedback.setNote(note);
        userfeedback.setExt(ext);
        userfeedback.setCreatedate(Calendar.getInstance().getTime());
        if (userservice.insertFeedBack(userfeedback) == 1) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failed(2060, "����ʧ��");
        }
    }

    @ResponseBody
    @RequestMapping("/modifyPwd")
    public AppJsonMessage modifyPwd(String data) {
        JSONObject json = JSONObject.parseObject(data);
        int type = json.getInteger("type");
        String userCode = json.getString("userCode");
        String oldPassword = json.getString("oldPassword");
        String newPassword = json.getString("newPassword");
        String newPassword1 = json.getString("newPassword1");
        String userEmail = json.getString("userEmail");
        if (type == 0 && !"".equals(oldPassword)) {
            JSONObject jsonObject = userservice.modifyPsw(userCode, oldPassword, newPassword, newPassword1);
            if (jsonObject.getIntValue("code") == 0) {
                return ResultUtil.success(jsonObject);
            } else {
                return ResultUtil.failed(jsonObject.getIntValue("code"), jsonObject.getString("msg"));
            }
        } else if (type == 1 && !"".equals(userEmail)) {
            return ResultUtil.failed(2012, "�ݲ�֧�������һ�");
        }
        return ResultUtil.failed(2000);
    }

    @ResponseBody
    @RequestMapping("/uploadUserLogo")
    public AppJsonMessage uploadUserLogo(HttpServletRequest request) throws IOException {
        String fileName = null;
        String ym = DateFormatUtils.format(Calendar.getInstance().getTime(), "yyyyMM");
        //����һ��ͨ�õĶಿ�ֽ�����
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //�ж� request �Ƿ����ļ��ϴ�,���ಿ������
        if (multipartResolver.isMultipart(request)) {
            //ת���ɶಿ��request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //ȡ��request�е������ļ���
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //ȡ���ϴ��ļ�
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //ȡ�õ�ǰ�ϴ��ļ����ļ�����
                    String myFileName = file.getOriginalFilename();
                    //������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������
                    if (myFileName.trim() != "") {
                        //�������ϴ�����ļ���
                        fileName = file.getOriginalFilename();
                        //�����ϴ�·��
                        String path = "F:\\uploads";
                        File dir = new File(path);
                        if (!dir.exists()) dir.mkdirs();
                        path += "\\" + ym + "_" + fileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
            }
        } else {
            return ResultUtil.failed(2040, "û���ļ�");
        }
        return ResultUtil.success(new JSONObject().put("userLogo", "/uploads/" + ym + "_" + fileName));
    }
}

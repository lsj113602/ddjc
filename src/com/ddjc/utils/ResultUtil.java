package com.ddjc.utils;

import com.ddjc.json.AppJsonMessage;

/**
 * author: LongDuping
 * date  : 2017-07-09 10:07
 * email : 610215675@qq.com
 * --------------------------------------------------
 * function:
 */
public class ResultUtil {

    public static AppJsonMessage success(){
        AppJsonMessage app = new AppJsonMessage();
        app.setCode(0);
        app.setMsg("操作成功");
        app.setData("");
        return app;
    }

    public static AppJsonMessage success(Object data){
        AppJsonMessage app = new AppJsonMessage();
        app.setCode(0);
        app.setMsg("操作成功");
        app.setData(data);
        return app;
    }

    public static AppJsonMessage failed(int code){
        AppJsonMessage app = new AppJsonMessage();
        app.setCode(code);
        app.setMsg("操作失败");
        app.setData("");
        return app;
    }

    public static AppJsonMessage failed(int code,String msg){
        AppJsonMessage app = new AppJsonMessage();
        app.setCode(code);
        app.setMsg(msg);
        app.setData("");
        return app;
    }
}

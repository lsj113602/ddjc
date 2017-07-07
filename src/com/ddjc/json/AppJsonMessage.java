package com.ddjc.json;

import java.io.Serializable;

import com.ddjc.tool.EnumDescribable;

public class AppJsonMessage implements Serializable
{
    //
    private static final long serialVersionUID = 714679657596837387L;
    
    public AppJsonMessage()
    {
    }
    
    public AppJsonMessage(EnumDescribable enumDescribable)
    {
        this.code = enumDescribable.getCode();
        this.msg = enumDescribable.getMessage();
    }
    
    private Integer code;//返回状态码
                    
    private String  msg;//返回信息
                    
    private Object  data;//返回数据
                    
    public Integer getCode()
    {
        return code;
    }
    
    public void setCode(Integer code)
    {
        this.code = code;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    public Object getData()
    {
        return data;
    }
    
    public void setData(Object data)
    {
        this.data = data;
    }
}
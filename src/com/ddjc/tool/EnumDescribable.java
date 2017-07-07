package com.ddjc.tool;

import java.io.Serializable;

public interface EnumDescribable extends Serializable
{
    /**
     * 获取异常代码
     * @return
     */
    Integer getCode();
    
    /**
     * 获取异常代码描述
     * @return
     */
    String getMessage();
}
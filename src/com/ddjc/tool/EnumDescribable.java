package com.ddjc.tool;

import java.io.Serializable;

public interface EnumDescribable extends Serializable
{
    /**
     * ��ȡ�쳣����
     * @return
     */
    Integer getCode();
    
    /**
     * ��ȡ�쳣��������
     * @return
     */
    String getMessage();
}
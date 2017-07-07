package com.ddjc.tool;

public enum CommonConst implements EnumDescribable
{
    // ״̬�뷶Χ��0 �� 999
    SUCCESS(0, "�����ɹ���"), //
    VALID_ERR(1001, "������֤����"), //
    VALID_OP_ERR(1002, "op����������Ҫ��δ���ҵ���Ӧ�ĵ��÷���"), //
    VALID_DATA_ERR(1003, "data����������Ҫ��"), //
    VALID_PHONE_ERR(2000, "�ֻ������ʽ����ȷ"), //
    VALID_CAPTCHA_ERR(2001, "��֤�����Ͳ���ȷ"), //
    PHONE_NUM_HAS_REGISTERED(2002, "�ֻ�������ע��"), //
    CHECKING_SELF_PRODUCT_ERR(2003, "�������ң�����������Ʒ����Ҫ����������˻�"), //
    MESSAGE_NOT_EXITS(2006, "��Ϣ������"), //
    CODE_HAS_EXPIRED(2010, "��֤���ѹ���"), //
    CODE_NOT_EQUAL(2011, "��֤�벻��ȷ"), USER_NOT_EXIST(2012, "�û�������"), //
    INVIRECODE_NOT_EXIST(2014, "�����벻����"), USER_MODIFY_FIAL(2016, "��½�����޸�ʧ��"), //
    USER_LOGIN_FAIL(2017, "�û������������"), //
    ADDRESS_ADD_FAIL(2023, "��ӵ�ַʧ��"), //
    FAVORITE_ADD_ERR(2029, "����ղ�ʧ��"), //
    FAVORITE_NOT_EXIST(2031, "�ղ���Ϣ������"), //
    FAVORITE_CANCEL_ERR(2032, "ȡ���ղ�ʧ��"), //
    ADDRESS_NOT_EXIST(2033, "��ַ������"), //
    COMMENT_NOT_EXIST(2034, "ɹ�������ڻ���ɾ��"), //
    DEBUG_MODEL_NOTSMS(2035, "���ŷ��ͷ����ѹر�,�������������ŷ���ſ�ͨ!"), //
    INVIRECODE_NOT_OWN(2036, "������д�Լ���������"), //
    ORDER_REPLY_FAIL(2044, "����ʧ�ܣ����۶����������۶��������"), //
    ORDER_CREATE_FAIL(2045, "�벻Ҫ�ظ���������"),//

    ;
    private CommonConst(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }
    
    /**
     * ����״̬���ȡ״̬������
     * @param code ״̬��
     * @return String ״̬������
     */
    public static String getMessage(Integer code)
    {
        String result = null;
        for (CommonConst c : CommonConst.values())
        {
            if (c.code.equals(code))
            {
                result = c.message;
            }
        }
        return result;
    }
    
    public Integer code;
    
    public String  message;
    
    /*
     * (non-Javadoc)
     * @see com.zttx.web.bean.EnumDescribable#getCode()
     */
    @Override
    public Integer getCode()
    {
        return this.code;
    }
    
    public void setCode(Integer code)
    {
        this.code = code;
    }
    
    /*
     * (non-Javadoc)
     * @see com.zttx.web.bean.EnumDescribable#getMessage()
     */
    @Override
    public String getMessage()
    {
        return this.message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
}

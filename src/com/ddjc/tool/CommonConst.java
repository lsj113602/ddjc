package com.ddjc.tool;

public enum CommonConst implements EnumDescribable
{
    // 状态码范围：0 到 999
    SUCCESS(0, "操作成功！"), //
    VALID_ERR(1001, "参数验证错误"), //
    VALID_OP_ERR(1002, "op参数不符合要求，未查找到对应的调用方法"), //
    VALID_DATA_ERR(1003, "data参数不符合要求"), //
    VALID_PHONE_ERR(2000, "手机号码格式不正确"), //
    VALID_CAPTCHA_ERR(2001, "验证码类型不正确"), //
    PHONE_NUM_HAS_REGISTERED(2002, "手机号码已注册"), //
    CHECKING_SELF_PRODUCT_ERR(2003, "您是卖家，不允许购买商品，如要购买，请更换账户"), //
    MESSAGE_NOT_EXITS(2006, "消息不存在"), //
    CODE_HAS_EXPIRED(2010, "验证码已过期"), //
    CODE_NOT_EQUAL(2011, "验证码不正确"), USER_NOT_EXIST(2012, "用户不存在"), //
    INVIRECODE_NOT_EXIST(2014, "邀请码不存在"), USER_MODIFY_FIAL(2016, "登陆密码修改失败"), //
    USER_LOGIN_FAIL(2017, "用户名或密码错误"), //
    ADDRESS_ADD_FAIL(2023, "添加地址失败"), //
    FAVORITE_ADD_ERR(2029, "添加收藏失败"), //
    FAVORITE_NOT_EXIST(2031, "收藏信息不存在"), //
    FAVORITE_CANCEL_ERR(2032, "取消收藏失败"), //
    ADDRESS_NOT_EXIST(2033, "地址不存在"), //
    COMMENT_NOT_EXIST(2034, "晒单不存在或已删除"), //
    DEBUG_MODEL_NOTSMS(2035, "短信发送服务已关闭,仅生产环境短信服务才开通!"), //
    INVIRECODE_NOT_OWN(2036, "不能填写自己的邀请码"), //
    ORDER_REPLY_FAIL(2044, "评论失败，评论订单或者评论订单项不存在"), //
    ORDER_CREATE_FAIL(2045, "请不要重复创建订单"),//

    ;
    private CommonConst(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }
    
    /**
     * 根据状态码获取状态码描述
     * @param code 状态码
     * @return String 状态码描述
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

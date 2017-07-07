package com.ddjc.utils;

public class ZttxConst
{
    private ZttxConst()
    {
    }

    /**
     * 当前页面
     */
    public static final Integer DEFAULT_CURRENT_PAGE  = 1;

    /**
     * 分页大小
     */
    public static final Integer DEFAULT_PAGE_SIZE     = 10;

    /**
     * 分页起始大小
     */
    public static final Integer DEFAULT_START_INDEX   = 0;

    /**
     * 默认域名
     */
    public static final String  DOMAIN                = "yangcongbuluo.com";

    /**
     * COOKIE存放路径
     */
    public static final String  COOKIE_PATH           = "/";

    /**
     * 分割符
     */
    public static final char    SEPARATOR             = '_';

    /**
     * 加密方式
     */
    public static final String  ENCRYPT               = "MD5";

    /**
     * 删除标记0正常,1已删除
     */
    public static final Boolean DEL_FLAG_NORMAl_BOOL  = false;

    /**
     * 删除标记0正常,1已删除
     */
    public static final Boolean DEL_FLAG_DELETED_BOOL = true;

    public static final String  TRUE                  = "true";

    public static final String  FALSE                 = "false";

    // URL分割标志符
    public static final String  PATH_SPARATOR         = "/";

    // 公用模块(如：注册、取回密码)
    public static final String  COMMON                = "/common";

    // 远程调用
    public static final String  CLIENT                = "/client";

    // 用户模块
    public static final String  USER                  = "/user";

    // 后台设置(如:用户管理,角色管理)
    public static final String  SETTING               = "/setting";

    // 商品中心
    public static final String  GOODS                 = "/goods";
    public static final String  GUIDE                 = "/guide";

    public static final String  APP_GOODS             = "/product";

    public static final String  APP_MARKET            = "/market";

    // 厂店后台
    public static final String  FACTORY               = "/factory";

    public static final String  INDEX                 = "/index";

    // 营销活动
    public static final String  ACTIVITY              = "/activity";

    // 圈子
    public static final String  COMMENT               = "/comment";

    // 优惠券
    public static final String  COUPON                = "/coupon";

    // 订单中心
    public static final String  ORDERS                = "/orders";

    // 交易中心
    public static final String  TRADE                 = "/trade";

    // 引擎引擎
    public static final String  SEARCH                = "/search";

    // 用户模块
    public static final String  AGENTS                = "/partner";

    // 统计
    public static final String  STATS                 = "/stats";

    //供应商
    public static final String  MERCHANT                 = "/merchantAward";

    // 属性项相关枚举类
    public static class CateAttributeItem
    {
        /**
         * 数据库颜色的编码
         */
        public static final String DEFAULT_COLOR_ID      = "3372";

        /**
         * 数据库尺码的编码
         */
        public static final String DEFAULT_SIZE_ID       = "101";

        /**
         * 非SKU属性的默认attributeItemID号<br>
         * <p>
         * SKU属性（颜色、尺码）都会包含SKUID，当前销售属性和产品属性都存储在
         * 同一张表里，为区分销售属性和产品属性，特此给产品属性默认一个SKUID
         * </p>
         */
        public static final String NONSKU_ATTRITEM_ID    = "11111_22222";

        /**
         * 非SKU属性的默认attributeID号<br>
         */
        public static final String NONSKU_ATTRIBUTE_ID   = "U00000000000000003";

        /**
         * 对于CateAttribute表内颜色属性，未定义具体颜色的项的ID
         */
        public static final String COLOR_UNDIFINED_ID    = "11111";             // 兼容 门店erp的默认值

        /**
         * 对于CateAttribute表内尺码属性，未定义具体尺码的项的ID
         */
        public static final String SIZE_UNDIFINED_ID     = "22222";             // 兼容 门店erp的默认值

        /**
         * 对于CateAttribute表内颜色属性，未定义具体颜色的项的值
         */
        public static final String COLOR_UNDIFINED_VALUE = "默认";

        /**
         * 对于CateAttribute表内尺码属性，未定义具体尺码的项的值
         */
        public static final String SIZE_UNDIFINED_VALUE  = "默认";

        public static final String STATE_ENABLE          = "1";

        public static final String STATE_DISABLED        = "0";
    }

    public static class CateAttribute
    {
        /**
         * 属性值操作选项： 单选
         */
        public static int OPERATE_CATE_SINGLE_SELECT = 1;

        /**
         * 属性值操作选项： 多选
         */
        public static int OPERATE_CATE_MULTI_SELECT  = 2;

        /**
         * 用户 可输入
         */
        public static int OPERATE_CATE_INPUT_VALUE   = 3;
    }
}

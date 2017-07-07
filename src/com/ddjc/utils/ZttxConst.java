package com.ddjc.utils;

public class ZttxConst
{
    private ZttxConst()
    {
    }

    /**
     * ��ǰҳ��
     */
    public static final Integer DEFAULT_CURRENT_PAGE  = 1;

    /**
     * ��ҳ��С
     */
    public static final Integer DEFAULT_PAGE_SIZE     = 10;

    /**
     * ��ҳ��ʼ��С
     */
    public static final Integer DEFAULT_START_INDEX   = 0;

    /**
     * Ĭ������
     */
    public static final String  DOMAIN                = "yangcongbuluo.com";

    /**
     * COOKIE���·��
     */
    public static final String  COOKIE_PATH           = "/";

    /**
     * �ָ��
     */
    public static final char    SEPARATOR             = '_';

    /**
     * ���ܷ�ʽ
     */
    public static final String  ENCRYPT               = "MD5";

    /**
     * ɾ�����0����,1��ɾ��
     */
    public static final Boolean DEL_FLAG_NORMAl_BOOL  = false;

    /**
     * ɾ�����0����,1��ɾ��
     */
    public static final Boolean DEL_FLAG_DELETED_BOOL = true;

    public static final String  TRUE                  = "true";

    public static final String  FALSE                 = "false";

    // URL�ָ��־��
    public static final String  PATH_SPARATOR         = "/";

    // ����ģ��(�磺ע�ᡢȡ������)
    public static final String  COMMON                = "/common";

    // Զ�̵���
    public static final String  CLIENT                = "/client";

    // �û�ģ��
    public static final String  USER                  = "/user";

    // ��̨����(��:�û�����,��ɫ����)
    public static final String  SETTING               = "/setting";

    // ��Ʒ����
    public static final String  GOODS                 = "/goods";
    public static final String  GUIDE                 = "/guide";

    public static final String  APP_GOODS             = "/product";

    public static final String  APP_MARKET            = "/market";

    // �����̨
    public static final String  FACTORY               = "/factory";

    public static final String  INDEX                 = "/index";

    // Ӫ���
    public static final String  ACTIVITY              = "/activity";

    // Ȧ��
    public static final String  COMMENT               = "/comment";

    // �Ż�ȯ
    public static final String  COUPON                = "/coupon";

    // ��������
    public static final String  ORDERS                = "/orders";

    // ��������
    public static final String  TRADE                 = "/trade";

    // ��������
    public static final String  SEARCH                = "/search";

    // �û�ģ��
    public static final String  AGENTS                = "/partner";

    // ͳ��
    public static final String  STATS                 = "/stats";

    //��Ӧ��
    public static final String  MERCHANT                 = "/merchantAward";

    // ���������ö����
    public static class CateAttributeItem
    {
        /**
         * ���ݿ���ɫ�ı���
         */
        public static final String DEFAULT_COLOR_ID      = "3372";

        /**
         * ���ݿ����ı���
         */
        public static final String DEFAULT_SIZE_ID       = "101";

        /**
         * ��SKU���Ե�Ĭ��attributeItemID��<br>
         * <p>
         * SKU���ԣ���ɫ�����룩�������SKUID����ǰ�������ԺͲ�Ʒ���Զ��洢��
         * ͬһ�ű��Ϊ�����������ԺͲ�Ʒ���ԣ��ش˸���Ʒ����Ĭ��һ��SKUID
         * </p>
         */
        public static final String NONSKU_ATTRITEM_ID    = "11111_22222";

        /**
         * ��SKU���Ե�Ĭ��attributeID��<br>
         */
        public static final String NONSKU_ATTRIBUTE_ID   = "U00000000000000003";

        /**
         * ����CateAttribute������ɫ���ԣ�δ���������ɫ�����ID
         */
        public static final String COLOR_UNDIFINED_ID    = "11111";             // ���� �ŵ�erp��Ĭ��ֵ

        /**
         * ����CateAttribute���ڳ������ԣ�δ��������������ID
         */
        public static final String SIZE_UNDIFINED_ID     = "22222";             // ���� �ŵ�erp��Ĭ��ֵ

        /**
         * ����CateAttribute������ɫ���ԣ�δ���������ɫ�����ֵ
         */
        public static final String COLOR_UNDIFINED_VALUE = "Ĭ��";

        /**
         * ����CateAttribute���ڳ������ԣ�δ��������������ֵ
         */
        public static final String SIZE_UNDIFINED_VALUE  = "Ĭ��";

        public static final String STATE_ENABLE          = "1";

        public static final String STATE_DISABLED        = "0";
    }

    public static class CateAttribute
    {
        /**
         * ����ֵ����ѡ� ��ѡ
         */
        public static int OPERATE_CATE_SINGLE_SELECT = 1;

        /**
         * ����ֵ����ѡ� ��ѡ
         */
        public static int OPERATE_CATE_MULTI_SELECT  = 2;

        /**
         * �û� ������
         */
        public static int OPERATE_CATE_INPUT_VALUE   = 3;
    }
}

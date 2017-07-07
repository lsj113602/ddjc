package com.ddjc.tool;

public class BusinessException extends Exception
{
    //
    private static final long serialVersionUID = -3267019434607947850L;
    
    private Integer           code;
    
    private Object            object;
    
    // ������������
    private EnumDescribable   errorCode;
    
    /**
     * Ŀǰҵ���쳣�ǳ��࣬ҵ���쳣����δ�����������ǵ�����ͳһ��ҵ���쳣������й淶��ŵ����⣬Ŀǰ���Ŵ˽ӿڽ�����ų���Ա�Ҳ����ض��Ĵ�����������
     *
     * @param message
     */
    public BusinessException(String message)
    {
        super(message);
        this.code = 9999;
        MyErrorCode myCode = new MyErrorCode();
        myCode.setCode(code);
        myCode.setMessage(message);
        this.errorCode = myCode;
    }
    
    /**
     * @param codeDescribable
     * @param object
     * @author �˽���
     */
    public BusinessException(EnumDescribable codeDescribable,  Object object)
    {
        super(new StringBuilder("Error code: ").append(codeDescribable.getCode()).append(", description: ").append(codeDescribable.getMessage()).toString());
        this.errorCode = codeDescribable;
        this.object = object;
    }
    
    public BusinessException(Integer code, String message)
    {
        super(message);
        this.code = code;
        MyErrorCode myCode = new MyErrorCode();
        myCode.setCode(code);
        myCode.setMessage(message);
        this.errorCode = myCode;
    }
    
    public BusinessException(Integer code, String message, Object object)
    {
        this(code, message);
        this.object = object;
    }
    
    /**
     * @author ����
     */
    public BusinessException(EnumDescribable codeDescribable)
    {
        super(new StringBuilder("Error code: ").append(codeDescribable.getCode()).append(", description: ").append(codeDescribable.getMessage()).toString());
        this.errorCode = codeDescribable;
    }
    
    public EnumDescribable getErrorCode()
    {
        return this.errorCode;
    }
    
    public Integer getCode()
    {
        return code;
    }
    
    public String getMessage()
    {
        return super.getMessage();
    }
    
    public Object getObject()
    {
        return object;
    }
    
    public void setObject(Object object)
    {
        this.object = object;
    }
    
    protected class MyErrorCode implements EnumDescribable
    {
        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = 7194581434568247909L;
        
        private Integer           code;
        
        private String            message;
        
        /*
         * (non-Javadoc)
         * @see com.f2c.bean.EnumDescribable#getCode()
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
         * @see com.f2c.bean.EnumDescribable#getMessage()
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
}

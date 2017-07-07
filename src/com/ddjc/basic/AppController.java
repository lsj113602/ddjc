package com.ddjc.basic;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddjc.json.AppJsonMessage;
import com.ddjc.tool.BeanValidators;
import com.ddjc.tool.BusinessException;
import com.ddjc.tool.EnumDescribable;

public abstract class AppController
{
    protected static final Logger logger = LoggerFactory.getLogger(AppController.class);
    
    /**
     * ��֤Beanʵ������
     */
    @Autowired
    protected Validator           validator;
    
    @Autowired
   // protected UserInfoService     userInfoService;
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView handleException(Exception ex)
    {
        ModelAndView mav = new ModelAndView();
        if(logger.isDebugEnabled()){
            ex.printStackTrace();
        }
        if (null != ex.getCause()) mav.addObject("exception", ex.getCause());
        if (ex instanceof BusinessException)
        { // �Զ���ҵ���쳣
            BusinessException bex = (BusinessException) ex;
            AppJsonMessage json = getJsonMessage(bex.getErrorCode());
            mav.addObject("code", json.getCode());
            mav.addObject("msg", json.getMsg());
            mav.addObject("data", bex.getObject());
        }
        else
        {
            mav.addObject("code", 1001);
            mav.addObject("msg", "ϵͳ����");
            mav.addObject("message", ex.getMessage());
        }
        return mav;
    }
    
    /**
     * ����SSOID��ȡ�û���ʵ���
     * @param unid
     * @return
     * @throws BusinessException
     */
/*    protected String findRealIdByUNID(String unid) throws BusinessException
    {
        String userId = (String) JedisUtils.hget(CacheConst.CACHE_USER_SSO_RELATION, unid);
        if (StringUtils.isBlank(userId))
        {
            UserInfo userInfo = userInfoService.findUserInfoByUNID(unid);
            if (null == userInfo) throw new BusinessException(CommonConst.USER_NOT_EXISTS);
            JedisUtils.hset(CacheConst.CACHE_USER_SSO_RELATION, unid, userInfo.getRefrenceId());
            userId = userInfo.getRefrenceId();
        }
        return userId;
    }*/
    
/*    *//**
     * ����unid��ȡ�û���Ϣ
     * @param unid
     * @return
     * @throws BusinessException
     *//*
    protected UserInfo findUserInfoByUNID(String unid) throws BusinessException
    {
        UserInfo userInfo = userInfoService.findUserInfoByUNID(unid);
        if (null == userInfo) { throw new BusinessException(CommonConst.USER_NOT_EXISTS); }
        return userInfo;
    }*/
    
    /**
     * ����˲�����Ч����֤
     *
     * @param object ��֤��ʵ�����
     * @param groups ��֤��
     * @return ��֤�ɹ�������true������ʧ�ܣ���������Ϣ��ӵ� message ��
     */
    protected boolean beanValidator(Model model, Object object, Class<?> ... groups)
    {
        try
        {
            BeanValidators.validateWithException(validator, object, groups);
        }
        catch (ConstraintViolationException ex)
        {
            List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
            list.add(0, "������֤ʧ�ܣ�");
            addMessage(model, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }
    
    /**
     * ����˲�����Ч����֤
     *
     * @param object ��֤��ʵ�����
     * @param groups ��֤��
     * @return ��֤�ɹ�������true������ʧ�ܣ���������Ϣ��ӵ� flash message ��
     */
    protected boolean beanValidator(RedirectAttributes redirectAttributes, Object object, Class<?> ... groups)
    {
        try
        {
            BeanValidators.validateWithException(validator, object, groups);
        }
        catch (ConstraintViolationException ex)
        {
            List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
            list.add(0, "������֤ʧ�ܣ�");
            addMessage(redirectAttributes, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }
    
    /**
     * ����˲�����Ч����֤
     * @param object ��֤��ʵ�����
     * @param groups ��֤��
     * @return ��֤�ɹ�������true������ʧ�ܣ���������Ϣ��ӵ� message ��
     */
    protected boolean beanValidatorNoProperty(Model model, Object object, Class<?> ... groups)
    {
        try
        {
            BeanValidators.validateWithException(validator, object, groups);
        }
        catch (ConstraintViolationException ex)
        {
            List<String> list = BeanValidators.extractMessage(ex);
            // list.add(0, "������֤ʧ��");
            addMessage(model, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }
    
    /**
     * ���Model��Ϣ
     *
     * @param model
     * @param messages
     */
    protected void addMessage(Model model, String ... messages)
    {
        StringBuilder sb = new StringBuilder();
        for (String message : messages)
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        model.addAttribute("message", sb.toString());
    }
    
    /**
     * ���Flash��Ϣ
     *
     * @param redirectAttributes
     * @param messages
     */
    protected void addMessage(RedirectAttributes redirectAttributes, String ... messages)
    {
        StringBuilder sb = new StringBuilder();
        for (String message : messages)
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        redirectAttributes.addFlashAttribute("message", sb.toString());
    }
    
    /**
     * ��ʼ�����ݰ�
     * 1. �����д��ݽ�����String����HTML���룬��ֹXSS����
     * 2. ���ֶ���Date����ת��ΪString����
     */
/*    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
        binder.registerCustomEditor(Byte.class, new ByteEditorSupport());
        binder.registerCustomEditor(Float.class, new FloatEditorSupport());
        binder.registerCustomEditor(Double.class, new DoubleEditorSupport());
        binder.registerCustomEditor(Long.class, new LongEditorSupport());
        binder.registerCustomEditor(Integer.class, new IntegerEditorSupport());
        binder.registerCustomEditor(Boolean.class, new BooleanEditorSupport());
        binder.registerCustomEditor(String.class, new StringEditorSupport());
        binder.registerCustomEditor(Short.class, new ShortEditorSupport());
    }*/
    
    /**
     * �ӿڴ��������� : ��API�ӿڷ������ݻ��״�������JSON����
     * @param describable �쳣��������
     *  {@link AppJsonMessage}
     */
    public AppJsonMessage getJsonMessage(EnumDescribable describable)
    {
        AppJsonMessage jsonMessage = new AppJsonMessage();
        jsonMessage.setCode(describable.getCode());
        jsonMessage.setMsg(describable.getMessage());
        return jsonMessage;
    }
    
    /**
     * �ӿڴ��������� : ��API�ӿڷ������ݻ��״�������JSON����
     * @param describable �쳣��������
     * @param object ��������ض���
     * @return {@link AppJsonMessage}
     */
    protected AppJsonMessage getJsonMessage(EnumDescribable describable, Object object)
    {
        AppJsonMessage jsonMessage = new AppJsonMessage();
        jsonMessage.setCode(describable.getCode());
        jsonMessage.setMsg(describable.getMessage());
        jsonMessage.setData(object);
        return jsonMessage;
    }
}
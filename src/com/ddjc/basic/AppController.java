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
     * 验证Bean实例对象
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
        { // 自定义业务异常
            BusinessException bex = (BusinessException) ex;
            AppJsonMessage json = getJsonMessage(bex.getErrorCode());
            mav.addObject("code", json.getCode());
            mav.addObject("msg", json.getMsg());
            mav.addObject("data", bex.getObject());
        }
        else
        {
            mav.addObject("code", 1001);
            mav.addObject("msg", "系统出错");
            mav.addObject("message", ex.getMessage());
        }
        return mav;
    }
    
    /**
     * 根据SSOID获取用户真实编号
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
     * 根据unid获取用户信息
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
     * 服务端参数有效性验证
     *
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；严重失败：将错误信息添加到 message 中
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
            list.add(0, "数据验证失败：");
            addMessage(model, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }
    
    /**
     * 服务端参数有效性验证
     *
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；严重失败：将错误信息添加到 flash message 中
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
            list.add(0, "数据验证失败：");
            addMessage(redirectAttributes, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }
    
    /**
     * 服务端参数有效性验证
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；严重失败：将错误信息添加到 message 中
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
            // list.add(0, "数据验证失败");
            addMessage(model, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }
    
    /**
     * 添加Model消息
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
     * 添加Flash消息
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
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
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
     * 接口处理结果反馈 : ：API接口返回数据或交易处理结果的JSON处理
     * @param describable 异常代码描述
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
     * 接口处理结果反馈 : ：API接口返回数据或交易处理结果的JSON处理
     * @param describable 异常代码描述
     * @param object 单结果返回对象
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
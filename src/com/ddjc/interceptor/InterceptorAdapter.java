package com.ddjc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class InterceptorAdapter extends HandlerInterceptorAdapter
{
    /**
     * ��̬������ESB��������в���
     * <p>
     *     ͨ��"op"�����Զ�·�ɵ�����Ŀ��Ʒ���
     * </p>
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String operator = request.getParameter("op");
        if (StringUtils.isBlank(operator)) return true;
        String process = (String) request.getAttribute("process");
        if (StringUtils.isNotBlank(process)) return true;
       // String url=request.getRequestURI();
        //String url=request.getRequestURL();//����ȫ·��
       // String url= request.getRequestURI();// ���س�ȥhost����������ip�����ֵ�·��
       // String url= request.getContextPath();// ���ع��������֣��������ӳ��Ϊ/���˴�������Ϊ��
        String url= request.getServletPath();// ���س�ȥhost�͹��������ֵ�·��
        String fullPath = new StringBuffer(url).append("/").append(operator).toString();
        request.setAttribute("process", "true");
        request.getRequestDispatcher(fullPath).forward(request, response);
        return false;
    }
}

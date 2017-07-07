package com.ddjc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class InterceptorAdapter extends HandlerInterceptorAdapter
{
    /**
     * 动态拦截由ESB请求的所有参数
     * <p>
     *     通过"op"参数自动路由到具体的控制方法
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
        //String url=request.getRequestURL();//返回全路径
       // String url= request.getRequestURI();// 返回除去host（域名或者ip）部分的路径
       // String url= request.getContextPath();// 返回工程名部分，如果工程映射为/，此处返回则为空
        String url= request.getServletPath();// 返回除去host和工程名部分的路径
        String fullPath = new StringBuffer(url).append("/").append(operator).toString();
        request.setAttribute("process", "true");
        request.getRequestDispatcher(fullPath).forward(request, response);
        return false;
    }
}

package com.zht.spring.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对某些接口进行放行
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse response, Object arg2) throws Exception {
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:9876");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Disposition,Origin, X-Requested-With, Content-Type, Accept,Authorization,id_token");

        //首页路径以及登录放行
        if ("/login/user".equals(arg0.getRequestURI())||"/login/coach".equals(arg0.getRequestURI())||"/login/admin".equals(arg0.getRequestURI())
            ||"/login/regist".equals(arg0.getRequestURI())||"/user/gallery".equals(arg0.getRequestURI()) ||"/captcha".equals(arg0.getRequestURI())
                ||"/login/out".equals(arg0.getRequestURI())
        ) {
            return true;}
        //重定向
        Object object = arg0.getSession().getAttribute("users");
        System.out.println(object);
        if (null == object) {
//            response.sendRedirect("/index/begin");
            return false;}
        return true;
    }
}
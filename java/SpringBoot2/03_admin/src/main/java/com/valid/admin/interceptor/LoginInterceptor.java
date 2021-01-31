package com.valid.admin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 登录检查
* 1. 配置好拦截器要拦截哪些请求
* 2. 把这些配置放在容器中
* */
public class LoginInterceptor implements HandlerInterceptor {

    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录检查
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        if(loginUser != null) {
            // 登录放行
            return true;
        }

        // 拦截住。未登录。跳转至登录页 这种方式session会丢失
//        session.setAttribute("msg", "请登录后重试");
//        response.sendRedirect("/");

        // 拦截住。未登录。跳转至登录页
        request.setAttribute("msg", "请登录后重试");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    // 目标方法执行之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    // 页面渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

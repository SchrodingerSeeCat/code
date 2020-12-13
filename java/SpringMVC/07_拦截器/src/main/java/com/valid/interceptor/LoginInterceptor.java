package com.valid.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 过滤登录用户
        HttpSession session = request.getSession();

        // 去登录界面放行
        if (request.getRequestURI().contains("goLogin")) {
            // 已经登录过重定向到首页
            if(session.getAttribute("userLoginInfo") != null) {
                request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
                return false;
            }
            return true;
        }

        // 正在登录放行
        if (request.getRequestURI().contains("login")) {
            return true;
        }

        // 有session放行
        if(session.getAttribute("userLoginInfo") != null) {
            return true;
        }

        // 没有登录重定向到登录界面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}

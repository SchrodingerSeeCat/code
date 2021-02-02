package com.valid.admin.config;

import com.valid.admin.interceptor.LoginInterceptor;
import com.valid.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
    * Filter和interceptor的区别
    * Filter是Servlet自定义的原生的组件。好处，脱离Spring应用也能使用
    * Interceptor是Spring定义的接口。可以使用Spring的自动装配功能
    * */
    @Autowired
    private RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")             // 拦截哪些请求，/**所有请求，静态资源也会被拦截
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/actuator/**", "/city/*", "/insert"); // 不拦截哪些请求

        // new RedisUrlCountInterceptor()不能使用new的方式创建依赖了别的组件的拦截器
        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/fonts/**", "/images/**", "/js/**");
    }
}

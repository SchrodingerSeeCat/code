package com.valid.demo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig1 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    // 数据源
    @Autowired
    private DataSource dataSource;

    // 配置数据库对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcToken = new JdbcTokenRepositoryImpl();
        jdbcToken.setDataSource(dataSource);
//        jdbcToken.setCreateTableOnStartup(true);
        return jdbcToken;
    }
    // 密码加密
    @Bean
    public PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 退出
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
        http.exceptionHandling().accessDeniedPage("/unauth.html"); // 没有权限跳转页面
        http.formLogin()                                    // 自己编写的登陆界面
            .loginPage("/login.html")                       // 登陆页面设置
            .loginProcessingUrl("/user/login")              // 登陆访问的路径
            .defaultSuccessUrl("/success.html").permitAll()   // 登陆成功后，重定向的地址
            .and().authorizeRequests()
            .antMatchers("/", "/test/hello", "/user/login", "/test/users", "/test/prefilter").permitAll() // 设置那些路径不需要认证
//            .antMatchers("/test/index").hasAuthority("admins") // 设置权限
//            .antMatchers("/test/index").hasAnyAuthority("admins,manager") // 设置权限
            .antMatchers("/test/index").hasRole("sale") // 设置权限
            .anyRequest().authenticated()
            .and().rememberMe().tokenRepository(persistentTokenRepository()) // 设置自动登陆
            .tokenValiditySeconds(60)                                       // 有效时长
            .userDetailsService(userDetailsService)
            .and().csrf().disable();                        // 关闭csrf防护
    }
}

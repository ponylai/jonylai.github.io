package org.spring.springboot.security;

import org.spring.springboot.service.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


/**
 * Created by jony.lai on 2017/5/25.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Autowired
    private UserDetailsService customUserService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService); //user Details Service楠岃瘉

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("*.html","/css/**","/js/**","/images/**","/toRegister","/helper","/login",
                		"/toLogin","/toLogout","/index","/","/api/getAllWish","/register","/api/getUser",
                		"/third/qq",
                		"*.js","*.gif","*.jpg","*.bmp","*.png","*.css","*.ico","/druid/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()//使用form表单登录
                .loginPage("/login")//登录页面
                .defaultSuccessUrl("/loginSuccess") //设置默认登录成功跳转页面,此处我修改为调到页面然后返回json，前端判断再js超链接到主页
                .failureUrl("/loginError")//登录错误跳转页面
                .permitAll() 
                .and()
                .csrf().disable()//禁用security的csrf
                .rememberMe().disable() //禁用记住我
                .logout()
                //默认注销行为为logout，可以通过下面的方式来修改
                .logoutUrl("/logout")
                //设置注销成功后跳转页面，默认是跳转到登录页面
                .logoutSuccessUrl("/toLogout")//注销成功跳转页面
                .permitAll();
      
                //.and()
                //开启cookie保存用户数据
                //.rememberMe()
                //设置cookie有效期
                //.tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                //.key("375113044");         

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
       
        http.sessionManagement().invalidSessionUrl("/login"); //session管理   session失效后跳转
        //只允许一个用户登录,如果同一个账户两次登录,那么第一个账户将被踢下线,跳转到登录页面
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");

    }

}


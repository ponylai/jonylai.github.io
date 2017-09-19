package org.spring.springboot.controller;


import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.spring.springboot.res.LoginRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by jony.lai on 07/02/2017.
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }
    
    @RequestMapping(value = "/toLogout")
    public String toLogout() {
        return "login";
    }
    
    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "register";
    }
    
    @RequestMapping(value = "/loginSuccess")
    @ResponseBody
    public LoginRes loginSuccess() {
    	LoginRes loginRes = new LoginRes();
    	loginRes.setResultCode("999999");
    	loginRes.setResultMsg("验证通过");
        return loginRes;
    }
    
    @RequestMapping(value = "/index")
    public String ToIndex() {
        return "index";
    }
    
    @RequestMapping(value = "/")
    public String domain() {
        return "index";
    }
    
    @RequestMapping("/login")
    public  LoginRes login(HttpServletRequest httpServletRequest){
    	LoginRes loginRes = new LoginRes();
    	Principal principal = httpServletRequest.getUserPrincipal();
        if(principal!=null){
        	loginRes.setResultCode("999999");
        	loginRes.setResultMsg("验证已通过");
        }else{
        	loginRes.setResultCode("000000");
        	loginRes.setResultMsg("验证未通过");
        }
        return loginRes;
    }
    
    @RequestMapping("/loginError")
    @ResponseBody
    public  LoginRes loginError(){
    	LoginRes loginRes = new LoginRes();
    	loginRes.setResultCode("000000");
    	loginRes.setResultMsg("验证错误");
        return loginRes;
    }
}

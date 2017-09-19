package org.spring.springboot.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import org.spring.springboot.domain.SysUser;
import org.spring.springboot.req.UserReq;
import org.spring.springboot.res.BaseRes;
import org.spring.springboot.res.UserRes;
import org.spring.springboot.service.UserService;
import org.spring.springboot.utils.SequenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by jony.lai on 07/02/2017.
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
   
    @RequestMapping(value = "/toUserCenter")
    public String toUserCenter() {
        return "userCenter";
    }
    
    @RequestMapping(value = "/register")
    @ResponseBody
    public BaseRes register(@RequestBody UserReq userReq,HttpServletRequest httpServletRequest) {
    	BaseRes baseRes = new BaseRes();
    	SysUser user = new SysUser();
    	long id = SequenceUtil.getSequence().nextId();
    	user.setId(id);
    	user.setChineseName(userReq.getChineseName());
    	user.setEmail(userReq.getEmail());
    	user.setPassword(userReq.getPassword());
    	user.setPhone(userReq.getPhone());
    	user.setUserName(userReq.getUserName());
    	
		Long count = userService.saveUser(user);
		if(count!=0){
			baseRes.setResultCode("000000");
			baseRes.setResultMsg("注册成功");
		}else{
			baseRes.setResultCode("999999");
			baseRes.setResultMsg("注册失败");
		}

		return baseRes;

    }
    
    @RequestMapping(value = "/api/getUser",method = RequestMethod.GET)
    @ResponseBody
    public BaseRes register(HttpServletRequest httpServletRequest) {
    	UserRes userRes = new UserRes();
    	SysUser user = new SysUser();
    	Principal principal = httpServletRequest.getUserPrincipal();
    	 if(principal!=null){
    		Object principal1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		UserDetails userDetails = (UserDetails) principal1; //用户信息
    	  	user.setUserName(userDetails.getUsername().toString());

    	  	
    	  	
    	  	
    	  	
    	  	userRes.setUser(user);
    	    //Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();//权限信息 
			userRes.setResultCode("000000");
			userRes.setResultMsg("注册成功");
		}else{
			userRes.setResultCode("999999");
			userRes.setResultMsg("注册失败");
		}

		return userRes;

    }
}

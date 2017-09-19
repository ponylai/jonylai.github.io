package org.spring.springboot.service;


import org.spring.springboot.dao.PermissionDao;
import org.spring.springboot.dao.UserDao;
import org.spring.springboot.domain.Permission;
import org.spring.springboot.domain.SysUser;
import org.spring.springboot.utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jony.lai
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserDao userDao;
    @Autowired
    PermissionDao permissionDao;

    public UserDetails loadUserByUsername(String username) {
    	SysUser user = null;
        try {
        	if(HelperUtils.checkEmail(username)){//判断是用邮箱登录的逻辑
        		String email = username;
        		user = userDao.findByEmail(email);
        		}
        	else if(HelperUtils.checkMobileNumber(username)){//判断是用手机号码登录的逻辑
        			String phone = username;
        			user = userDao.findByPhone(phone);
        			}else{
        				user = userDao.findByUserName(username);//判断用户名登录的逻辑
        					}
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <GrantedAuthority>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                grantedAuthorities.add(grantedAuthority);
                }
            }
            
            if(HelperUtils.checkEmail(username)){//判断是用邮箱登录
            	return new User(user.getEmail(), user.getPassword(), grantedAuthorities);
        		}
        	else if(HelperUtils.checkMobileNumber(username)){//判断是用手机号码登录
        			return new User(String.valueOf(user.getPhone()), user.getPassword(), grantedAuthorities);
        			}else{
        				return new User(user.getUserName(), user.getPassword(), grantedAuthorities);//判断用户名登录
        					}
            //return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("用户:" + username + " do not exist!");
        }
    }

}

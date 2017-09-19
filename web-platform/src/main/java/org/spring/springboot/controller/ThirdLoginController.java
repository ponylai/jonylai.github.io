package org.spring.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.spring.springboot.dao.PermissionDao;
import org.spring.springboot.dao.UserDao;
import org.spring.springboot.domain.Permission;
import org.spring.springboot.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 第三方登录 实现 Restful HTTP 服务
 * <p>
 * Created by jony.lai on 07/02/2017.
 */
@Controller
public class ThirdLoginController {
    
	@Autowired
	private UserDao userDao;
	@Autowired
	private PermissionDao permissionDao;
	
    @RequestMapping(value = "/third/qq")
    public String OpenIdByQQ(HttpServletRequest req, Model model) {
    		String openid = req.getParameter("openid");
    		model.addAttribute("openid", openid);
    		SysUser user = null;
    		UserDetails ud = null;
    		List<GrantedAuthority> grantedAuthorities = new ArrayList <GrantedAuthority>();
            try {
            	user = userDao.findByQQ(openid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (user != null) {
                List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
                grantedAuthorities = new ArrayList <GrantedAuthority>();
                for (Permission permission : permissions) {
                    if (permission != null && permission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                    }
                }
                ud = new User(user.getUserName(), user.getPassword(), grantedAuthorities);
            } else {
                throw new UsernameNotFoundException("用户:" + openid +"对应的用户"+ " do not exist!");
            }
            Authentication authentication = new UsernamePasswordAuthenticationToken(ud,
            		null, grantedAuthorities); //  设置Authentication的值、包含user、permission
            SecurityContextHolder.getContext().setAuthentication(authentication);// 将token传递给Authentication放进session
        return "index";
    }
    
}

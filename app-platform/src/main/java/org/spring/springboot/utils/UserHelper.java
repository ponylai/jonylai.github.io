package org.spring.springboot.utils;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by jony.lai on 2017/6/12.
 */
public class UserHelper {
    private static Logger logger = (Logger) LoggerFactory.getLogger(WriteScriptFile.class);
    public static UserDetails getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal; //用户信息
        logger.debug(userDetails.getUsername().toString());
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();//权限信息
        logger.debug(authorities.toString());
        return userDetails;
    }

}

package org.spring.springboot.service;

import org.spring.springboot.domain.SysUser;

/**
 * 用户业务逻辑接口类
 *
 * Created by jony.lai on 07/02/2017.
 */
public interface UserService {

    

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    Long saveUser(SysUser user);

   

}

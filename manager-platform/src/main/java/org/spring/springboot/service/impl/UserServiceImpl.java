package org.spring.springboot.service.impl;

import org.spring.springboot.dao.UserDao;
import org.spring.springboot.domain.SysUser;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 城市业务逻辑实现类
 *
 * Created by jony.lai on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增用户信息
     *
     * @param user
     */
    @Override
    @Transactional
    public Long saveUser(SysUser user) {
    	long countRU = userDao.saveRoleUser(user);
    	long countU = userDao.saveUser(user);
        return countRU+countU;
    }

}

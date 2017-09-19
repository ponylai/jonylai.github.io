package org.spring.springboot.dao;

import org.spring.springboot.domain.SysUser;

public interface UserDao {
    public SysUser findByUserName(String username);
    
    public long saveUser(SysUser sysUser);
    
    public long saveRoleUser(SysUser sysUser);
}

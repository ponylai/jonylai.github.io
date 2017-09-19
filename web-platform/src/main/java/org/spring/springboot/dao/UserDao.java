package org.spring.springboot.dao;

import org.spring.springboot.domain.SysUser;

public interface UserDao {
    public SysUser findByUserName(String username);
    public SysUser findByPhone(String phone);
    public SysUser findByEmail(String email);
    public SysUser findByQQ(String openid);
    
    public long saveUser(SysUser sysUser);
    
    public long saveRoleUser(SysUser sysUser);
}

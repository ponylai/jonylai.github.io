package org.spring.springboot.res;

import org.spring.springboot.domain.SysUser;

public class UserRes extends BaseRes{

	private SysUser user;

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}


}

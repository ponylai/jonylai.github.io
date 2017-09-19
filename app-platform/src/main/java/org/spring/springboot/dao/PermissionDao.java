package org.spring.springboot.dao;

import java.util.List;
import org.spring.springboot.domain.Permission;

/**
 * Created by jony.lai on 17/1/20.
 */
public interface PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(long userId);
}

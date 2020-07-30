package com.cadmin.cadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Role;

/**
 * 角色服务
 * @author elliot
 * @date 2020/07/27
 */
public interface RoleService {

    /**
     * 是否存在判断
     * @param role
     * @return
     */
    Boolean isExist(Role role);

    /**
     * 新增角色
     * @param role
     */
    void saveRole(Role role);

    /**
     * 删除角色
     * @param ids
     */
    void deleteRole(String ids);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(Role role);


    /**
     * 分页查询角色
     * @param page
     * @param role
     * @return
     */
    Page<Role> selectPageRole(Page page, Role role);

}

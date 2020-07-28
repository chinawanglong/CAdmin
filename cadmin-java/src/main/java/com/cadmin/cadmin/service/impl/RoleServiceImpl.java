package com.cadmin.cadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Role;
import com.cadmin.cadmin.mapper.RoleMapper;
import com.cadmin.cadmin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 角色服务实现类
 * @author elliot
 * @date 2020/07/27
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 新增角色
     *
     * @param role
     */
    @Override
    public void saveRole(Role role){
        roleMapper.insert(role);
    }

    /**
     * 删除角色
     *
     * @param ids
     */
    @Override
    public void deleteRole(String ids) {
        List<String> idArr = Arrays.asList(ids.split(","));
        roleMapper.deleteBatchIds(idArr);
    }

    /**
     * 更新角色
     *
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        if (null == role.getId()){
            throw new RuntimeException("主键id不能为空");
        }
        roleMapper.updateById(role);
    }

    /**
     * 分页查询角色
     *
     * @param page
     * @param role
     * @return
     */
    @Override
    public Page<Role> selectPageRole(Page page, Role role) {
        return roleMapper.selectPageRole(page, role);
    }
}

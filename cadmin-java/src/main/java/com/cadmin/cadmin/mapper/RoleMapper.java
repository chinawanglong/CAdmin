package com.cadmin.cadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 角色对象相关数据操作
 * @author elliot
 * @date 2020/07/27
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper {

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
     * 修改角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 角色分页查询
     * @param page
     * @param role
     * @return
     */
    Page<Role> selectPageRole(Page page, Role role);


}

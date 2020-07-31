package com.cadmin.cadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Role;
import com.cadmin.cadmin.service.RoleService;
import com.cadmin.cadmin.service.impl.RoleServiceImpl;
import com.cadmin.cadmin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elliot
 * @date 2020/07/28
 */
@RestController
@RequestMapping(value = "/admin/role")
public class RoleController {
//    @Autowired
//    private RoleServiceImpl roleService;

    @Autowired
    private RoleService roleService;


    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping(value = "/saveRole")
    public JsonResult saveRole(Role role){
        if (null == role){
            return JsonResult.fail(2001, "缺少必要的参数");
        }
        if (roleService.isExist(role)){
            return JsonResult.fail(2002, "不可重复添加");
        }
        roleService.saveRole(role);
        return JsonResult.success(1, "操作成功");
    }


    /**
     * 删除角色
     * @param ids
     * @return
     */
    @PostMapping(value = "/deleteRole")
    public JsonResult deleteRole(String ids){
        if (null == ids){
            return JsonResult.fail(2001, "缺少必要参数");
        }
        roleService.deleteRole(ids);
        // @todo 角色删除的同时，删除用户和相关角色关联关系
        return JsonResult.success(1, "操作成功");
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @PostMapping(value = "/updateRole")
    public JsonResult updateRole(Role role){
        if (null == role.getId()){
            return JsonResult.fail(2001, "缺少必要参数");
        }
        if (roleService.isExist(role)){
            return JsonResult.fail(2002, "不可重复添加");
        }
        roleService.updateRole(role);
        return JsonResult.success(1, "操作成功");
    }


    /**
     * 查询分页数据
     * @param page
     * @param role
     * @return
     */
    @PostMapping(value = "/selectRole")
    public JsonResult<Page<Role>> selectPageRole(Page page, Role role){
        Page<Role> data = roleService.selectPageRole(page, role);
        return JsonResult.success(1, "操作成功", data);
    }


}

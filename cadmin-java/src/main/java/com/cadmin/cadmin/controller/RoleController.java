package com.cadmin.cadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Role;
import com.cadmin.cadmin.service.impl.RoleServiceImpl;
import com.cadmin.cadmin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elliot
 * @date 2020/07/28
 */
@RestController
@RequestMapping(value = "/admin/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;


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
        return JsonResult.success(1, "操作成功");
    }

    @PostMapping(value = "/updateRole")
    public JsonResult updateRole(Role role){
        return JsonResult.success(1, "操作成功");
    }


    public JsonResult<Page<Role>> selectPageRole(Page page, Role role){
        return JsonResult.success(1, "操作成功");
    }


}

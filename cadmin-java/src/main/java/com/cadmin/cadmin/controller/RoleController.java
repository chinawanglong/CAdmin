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


    @PostMapping(value = "/saveRole")
    public JsonResult saveRole(Role role){

        return JsonResult.success(1, "操作成功");
    }


    @PostMapping(value = "/deleteRole")
    public JsonResult deleteRole(String ids){

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

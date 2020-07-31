package com.cadmin.cadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Menu;
import com.cadmin.cadmin.service.MenuService;
import com.cadmin.cadmin.service.impl.MenuServiceImpl;
import com.cadmin.cadmin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 *
 * @author elliot
 * @date 2020/07/17
 */
@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    /**
     * 获取树形菜单
     * @return
     */
//    @GetMapping("/treeList")
//    public JsonResult getMenuTree(){
//         List<Menu> menuData = menuService.getMenuTree(1);

//         return new JsonResult(0, "菜单获取成功", menuData);
//    }


    /**
     * 查询菜单的页面数据
     *
     * @param page
     * @param menu
     * @return
     */
    @PostMapping(value = "/selectMenu")
    public JsonResult<Page<Menu>> selectPageMenu(Page page, Menu menu){
        Page<Menu> result = menuService.selectPageMenu(page, menu);
        return JsonResult.success(result);
    }

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @PostMapping(value = "/saveMenu")
    public JsonResult saveMenu(Menu menu){
        if (null == menu.getTitle() || null == menu.getPath() || null == menu.getPid()){
            return JsonResult.fail(2001, "缺少必要参数");
        }
        if (menuService.isExistMenu(menu)){
            return JsonResult.fail(2002, "不可重复添加");
        }
        menuService.saveMenu(menu);
        return JsonResult.success();
    }

    /**
     * 删除菜单
     * @param ids
     * @return
     */
    @PostMapping(value = "/deleteMenu")
    public JsonResult deleteMenu(String ids){
        if (null == ids){
            return JsonResult.fail(2001, "缺少必要参数");
        }
        // @todo 是否是父级菜单，删除父级菜单的同时，下级菜单一并删除

        menuService.deleteMenu(ids);

        return JsonResult.success();
    }


    /**
     * 更新菜单
     *
     * @param menu
     * @return
     */
    @PostMapping(value = "/updateMenu")
    public JsonResult updateMenu(Menu menu){
        if (null == menu.getId()){
            return JsonResult.fail(2002, "缺少必要的参数");
        }
        if (menuService.isExistMenu(menu)){
            return JsonResult.fail(2003, "不可重复添加");
        }
        menuService.updateMenu(menu);

        return JsonResult.success();
    }









}

package com.cadmin.cadmin.controller;

import com.cadmin.cadmin.entity.Menu;
import com.cadmin.cadmin.service.impl.MenuServiceImpl;
import com.cadmin.cadmin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author elliot
 * @date 2020/07/17
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;


    /**
     * 获取树形菜单
     * @return
     */
    @GetMapping("/list")
    public JsonResult getMenuTree(){
         List<Menu> menuData = menuService.getMenuTree(1);

         return new JsonResult(0, "菜单获取成功", menuData);
    }

}

package com.cadmin.cadmin.utils;

import com.cadmin.cadmin.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author elliot
 * @date 2020/07/17
 */
public class MenuUtil {

    public static List<Menu> getMenuTree(List<Menu> menuRoot){

        List<Menu> menusResult = new ArrayList<>();
        // 一级菜单
        for (Menu menu:menuRoot){
            if (menu.getPid() == 0){
                menusResult.add(menu);
            }
        }
        // 后面等级菜单处理
        for (Menu menu:menusResult){
            menu.setChildMenus(getChildTree(menu.getId(), menuRoot));
        }

        return menusResult;
    }

    /**
     * 下级菜单的树形结构处理
     * @param id
     * @param menuRoot
     * @return
     */
    public static List<Menu> getChildTree(Long id, List<Menu> menuRoot){
        List<Menu> childMenuResult = new ArrayList<>();
        // 二级菜单
        for(Menu menu:menuRoot){
            if (menu.getPid().equals(id)){
                childMenuResult.add(menu);
            }
        }
        // 三级菜单及三级以后的菜单
        for (Menu menu:childMenuResult){
            if (menu.getPid() != 0){
                menu.setChildMenus(getChildTree(menu.getId(), menuRoot));
            }
        }

        if (childMenuResult.size() == 0){
            return null;
        }

        return childMenuResult;
    }
}

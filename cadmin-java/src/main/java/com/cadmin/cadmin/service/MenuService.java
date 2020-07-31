package com.cadmin.cadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Menu;

import java.util.List;

/**
 * @author elliot
 * @date 2020/07/17
 */
public interface MenuService {

    /**
     * 获取菜单列表
     * @param isShow
     * @return
     */
    List<Menu> getMenuList(Integer isShow);

    /**
     * 查询菜单的分页数据
     * @param page
     * @param menu
     * @return
     */
    Page<Menu> selectPageMenu(Page page, Menu menu);



    /**
     * 是否存在相同的菜单
     * @param menu
     * @return
     */
    boolean isExistMenu(Menu menu);

    /**
     * 新增菜单
     * @param menu
     */
    void saveMenu(Menu menu);

    /**
     * 删除菜单
     * @param ids
     */
    void deleteMenu(String ids);


    /**
     * 更新菜单
     * @param menu
     */
    void updateMenu(Menu menu);



}

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
     * 获取菜单分页数据
     * @param page
     * @return
     */
    Page<Menu> queryMenuList(Page page);

}

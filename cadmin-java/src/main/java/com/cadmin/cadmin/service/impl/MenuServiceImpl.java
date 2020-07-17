package com.cadmin.cadmin.service.impl;

import com.cadmin.cadmin.entity.Menu;
import com.cadmin.cadmin.mapper.MenuMapper;
import com.cadmin.cadmin.service.MenuService;
import com.cadmin.cadmin.utils.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单的逻辑处理
 * @author elliot
 * @date 2020/07/17
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    /**
     * 获取菜单列表
     *
     * @param isShow
     * @return
     */
    @Override
    public List<Menu> getMenuList(Integer isShow) {
        return menuMapper.getMenuList(isShow);
    }

    /**
     * 获取树形菜单，所有可见的菜单 1可见 0不可见
     * @return
     */
    public List<Menu> getMenuTree(Integer isShow){
        return MenuUtil.getMenuTree(getMenuList(isShow));
    }
}

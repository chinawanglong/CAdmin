package com.cadmin.cadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Menu;
import com.cadmin.cadmin.mapper.MenuMapper;
import com.cadmin.cadmin.service.MenuService;
import com.cadmin.cadmin.utils.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
     * 查询菜单的分页数据
     *
     * @param page
     * @param menu
     * @return
     */
    @Override
    public Page<Menu> selectPageMenu(Page page, Menu menu) {
        Page<Menu> result = menuMapper.selectPageMenu(page, menu);
        return result;
    }

    /**
     * 是否存在相同的菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean isExistMenu(Menu menu) {
        int count;
        // 新增，是否重复判断
        if (null == menu.getId()){
            count = menuMapper.selectCount(new QueryWrapper<Menu>().eq("title", menu.getTitle()).eq("pid", menu.getPid()));
        } else {
            // 更新，重复性判断
            count = menuMapper.selectCount(new QueryWrapper<Menu>().ne("id", menu.getId()).eq("title", menu.getTitle()).eq("pid", menu.getPid()));
        }
        return count > 0;
    }

    /**
     * 新增菜单
     *
     * @param menu
     */
    @Override
    public void saveMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    /**
     * 删除菜单
     *
     * @param ids
     */
    @Override
    public void deleteMenu(String ids) {
        List<String> idArr = Arrays.asList(ids.split(","));
        menuMapper.deleteBatchIds(idArr);
    }

    /**
     * 更新菜单
     *
     * @param menu
     */
    @Override
    public void updateMenu(Menu menu) {
        if (null == menu.getId()){
            throw new RuntimeException("缺少必要参数");
        }
        menuMapper.updateById(menu);
    }

    /**
     * 获取树形菜单，所有可见的菜单 1可见 0不可见
     * @return
     */
    public List<Menu> getMenuTree(Integer isShow){
        return MenuUtil.getMenuTree(getMenuList(isShow));
    }
}

package com.cadmin.cadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadmin.cadmin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author elliot
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取所有显示的菜单
     * @param isShow 0 不显示 1显示
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

}

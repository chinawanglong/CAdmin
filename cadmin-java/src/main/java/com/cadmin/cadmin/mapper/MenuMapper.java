package com.cadmin.cadmin.mapper;

import com.cadmin.cadmin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author elliot
 */
@Mapper
@Repository
public interface MenuMapper {

    /**
     * 获取所有显示的菜单
     * @param isShow 0 不显示 1显示
     * @return
     */
    List<Menu> getMenuList(Integer isShow);

}

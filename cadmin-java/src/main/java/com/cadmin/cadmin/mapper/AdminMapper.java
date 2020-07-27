package com.cadmin.cadmin.mapper;

import com.cadmin.cadmin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface AdminMapper {

    /**
     * 根据用户查询
     * @param username
     * @return
     */
    Admin selectByUsername(String username);

    /**
     * 查询角色
     * @param username
     * @return
     */
    Set<String> selectRoleByUsername(String username);
}

package com.cadmin.cadmin.mapper;

import com.cadmin.cadmin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface AdminMapper {

    Admin getByUsername(String username);

    Set<String> getRoleByUsername(String username);
}

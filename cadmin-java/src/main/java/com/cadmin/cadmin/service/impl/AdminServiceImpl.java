package com.cadmin.cadmin.service.impl;

import com.cadmin.cadmin.entity.Admin;
import com.cadmin.cadmin.mapper.AdminMapper;
import com.cadmin.cadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    @Override
    public Set<String> getRoleByUsername(String username) {
        return adminMapper.getRoleByUsername(username);
    }
}

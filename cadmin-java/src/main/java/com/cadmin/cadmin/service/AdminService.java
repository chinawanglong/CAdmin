package com.cadmin.cadmin.service;

import com.cadmin.cadmin.entity.Admin;

import java.util.Set;

public interface AdminService {

    Admin getByUsername(String username);

    Set<String> getRoleByUsername(String username);

}

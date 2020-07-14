package com.cadmin.cadmin.service;

public interface UserService {

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    String Login(String username, String password);
}

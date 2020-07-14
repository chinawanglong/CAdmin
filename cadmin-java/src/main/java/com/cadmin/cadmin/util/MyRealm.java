package com.cadmin.cadmin.util;

import com.cadmin.cadmin.entity.Admin;
import com.cadmin.cadmin.service.impl.AdminServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminServiceImpl adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 给该用户设置角色，角色信息存储在c_role表中
        simpleAuthorizationInfo.setRoles(adminService.getRoleByUsername(username));

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 根据token获取用户名
        String username = (String) authenticationToken.getPrincipal();
        // 根据用户名从数据库中查询用户
        Admin admin = adminService.getByUsername(username);
        if (null != admin){
            // 把用户存储到session中
            SecurityUtils.getSubject().getSession().setAttribute("admin", username);
            // 传入用户名和密码进行身份认证，并返回认证信息
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(admin.getUsername(), admin.getPassword(), "MyRealm");

            return authenticationInfo;
        }
        return null;
    }
}

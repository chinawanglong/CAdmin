package com.cadmin.cadmin.config;

import com.cadmin.cadmin.utils.MyRealm;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Log4j2
public class ShiroConfig {

    /**
     * 授权规则
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        // 定义shiroFilterBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置自定义的securityManger
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 设置默认登陆的url， 身份认证失败会访问该url
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置成功之后的跳转
        shiroFilterFactoryBean.setSuccessUrl("/success");
        // 设置未授权洁面，权限认证失败会访问该url
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap是有序的，进行顺序拦截器设置
        Map<String, String> filterChainMap = new LinkedHashMap<>();

        // 配置可以匿名访问的地址，可以根据实际情况添加，放一些静态资源等， anon表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/imgs/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/swagger-*/**", "anon");
        // 登陆url 放行
        filterChainMap.put("/login", "anon");

        // "/user/admin" 开头的需要身份认证，authc表示需要身份认证
        filterChainMap.put("/user/admin*", "authc");
        // "/user/student" 开头的需要角色认证，是'admin'才允许
        filterChainMap.put("/user/student*/**", "roles[admin]");
        // "user/teacher"开头的需要权限认证，是"user:create"才允许
        filterChainMap.put("/user/teacher*/**", "perms[\"user:create\"]");

        // 配置logout过滤器
        filterChainMap.put("/logout", "logout");

        // 配置shiroFilterFactoryBean的filterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        log.info("=====shiroFilterFactoryBean注册完成=====");
        return shiroFilterFactoryBean;
    }

    /**
     * 注入自定义的realm
     * @return
     */
    @Bean
    public MyRealm myAuthRealm(){
        MyRealm myRealm = new MyRealm();
        log.info("====MyRealm注册完成====");
        return myRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm());
        log.info("====securityManager注册完成====");
        return  securityManager;
    }




}

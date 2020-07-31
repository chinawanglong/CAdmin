package com.cadmin.cadmin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分页插件
 * @author elliot
 * @date 2020/07/31
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置最大单页限制数量，默认500，-1不限制
        paginationInterceptor.setLimit(5000);
        // 设置方言类型
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}

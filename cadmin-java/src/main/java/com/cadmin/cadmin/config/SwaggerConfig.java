package com.cadmin.cadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger在线接口文档
 * @author elliot
 * @date 2020-06-22
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller 中的所有接口
                .apis(RequestHandlerSelectors.basePackage("com.cadmin.cadmin.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建API文档的详细信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 接口标题
                .title("swagger在线接口文档")
                .description("CAdmin接口文档")
                .contact("")
                .version("1.0")
                .build();
    }
}

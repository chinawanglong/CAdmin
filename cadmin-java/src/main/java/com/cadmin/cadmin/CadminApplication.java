package com.cadmin.cadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cadmin.cadmin.mapper")
public class CadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadminApplication.class, args);
    }

}

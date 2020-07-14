package com.cadmin.cadmin.controller;

import com.cadmin.cadmin.model.entity.Administrator;
import com.cadmin.cadmin.util.JsonResult;
import io.swagger.annotations.*;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/admin")
@Api(tags = "后台登陆")
public class LoginController {


    @PostMapping("/login")
    @ApiOperation(value = "用户后台登陆")
    @ApiImplicitParams({
        @ApiImplicitParam(value = ""),
    })
    @ApiResponses({

    })
    public JsonResult login(Administrator administrator, HttpServletRequest){
        // 根据用户名和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(administrator.getUsername(), administrator.getPassword());
        // 获取subject认证主体
//        Subject subject = SecurityManager.getSubject();


        // 所有的逻辑处理放在service中完成

        return new JsonResult(0, "登陆成功", null);
    }
}

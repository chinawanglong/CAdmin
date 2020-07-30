package com.cadmin.cadmin.controller;

import com.cadmin.cadmin.entity.Admin;
import com.cadmin.cadmin.service.impl.AdminServiceImpl;
import com.cadmin.cadmin.utils.JsonResult;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/admin")
@Api(tags = "后台登陆")
public class LoginController {


    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/login")
    @ApiOperation(value = "用户后台登陆")
    public JsonResult login(Admin admin, HttpServletRequest request){
        // 根据用户名和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUsername(), admin.getPassword());
        // 获取subject认证主体
        Subject subject = SecurityUtils.getSubject();
        try{
            // 开始认证 这一步会跳转至自定义的realm中
            subject.login(token);
            Admin adminInfo = adminService.getByUsername(admin.getUsername());
            request.getSession().setAttribute("admin", admin);
            return JsonResult.success(0, "登陆成功", adminInfo);
        } catch (Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("admin", admin);
        }
        return JsonResult.fail(1001, "用户名或密码错误");
    }
}

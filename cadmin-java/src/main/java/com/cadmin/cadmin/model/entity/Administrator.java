package com.cadmin.cadmin.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 后端administrator 管理员实体类
 */
@Data // 替代get set
@AllArgsConstructor // 有参构造
@NoArgsConstructor // 无参构造
public class Administrator {

    private Long id; // 主键

    private String username; // 用户名

    private String password;  // 登录密码

    private Date created; // 创建时间

}

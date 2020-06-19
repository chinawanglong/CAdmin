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

    private String account; // 登录账号

    private String password;  // 登录密码

    private Integer status; // 账号状态

    private String character; // 角色名称

    private String remarks; // 备注

    private Date createdTime; // 创建时间

    private Long createdBy; // 创建人

    private Date updateTime; // 更新时间

    private Long updateBy; // 更新操作人

}

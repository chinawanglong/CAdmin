package com.cadmin.cadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "c_admin")
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private Date created;
}

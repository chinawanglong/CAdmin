package com.cadmin.cadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author elliot
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "c_menu")
public class Menu implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("菜单名")
    private String title;
    @ApiModelProperty("模块")
    private String name;
    @ApiModelProperty("路径")
    private String path;
    @ApiModelProperty("是否显示")
    private Integer is_show;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("父级菜单")
    private Long pid;
    @ApiModelProperty("创建时间")
    private Date created;
    @ApiModelProperty("更新时间")
    private Date update_time;

    @TableField(exist = false)
    private List<Menu> childMenus;
}


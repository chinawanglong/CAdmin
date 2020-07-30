package com.cadmin.cadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色对象
 * @author elliot
 * @date 2020/07/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "角色表")
@TableName(value = "c_role")
public class Role {
    private static final Long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "角色名")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private Date created;

}

DROP TABLE IF EXISTS `ca_administrator`;
CREATE table `ca_administrator`(
    `id` int(11) unsigned not null auto_increment,
    `username` varchar(30) not null default'管理员' comment'管理员名称',
    `account` varchar(30) not null comment'登录账户',
    `password` varchar(30) not null comment'登录密码',
    `status` smallint(2) not null default'1' comment'1正常 2冻结账号 3离职，4已删除',
    `create_time` datetime,
    `update_time` datetime not null default now(),
    `delete_time` datetime,
    primary key(`id`)
)engine=innodb default charset=utf8 comment='管理员表';


DROP TABLE IF EXISTS `ca_menus`;
CREATE table `ca_menus`(
    `id` int(11) unsigned auto_increment,
    `name` varchar(20) not null comment'菜单名称',
    `pid` int(11) not null default 0 comment'父级菜单',
    `order` smallint(2) not null default 1 comment'排序，最高级1，序号相同按照名称首字母排序',
    `create_time` datetime comment'创建时间',
    `update_time` datetime not null default now() comment'更新时间',
    primary key(`id`)
)engine=innodb default charset=utf8 comment='菜单表';

DROP TABLE IF EXISTS `ca_role`;
create table `ca_role`(
    `id` int(11) unsigned auto_increment,
    `name` varchar(20) not null comment'角色名称',
    `create_time` datetime comment'创建时间',
    primary key(`id`)
)engine=innodb default charset=utf8 comment='角色表';

DROP TABLE IF EXISTS `ca_role_administrator`;
create table `ca_role_administrator`(
    `id` int(11) unsigned auto_increment,
    `admin_id` int(11) unsigned not null comment'管理员ID',
    `role_id` int(11) unsigned not null comment'角色ID',
    primary key(`id`)
)engine=innodb default charset=utf8 comment='管理员-角色关系表';



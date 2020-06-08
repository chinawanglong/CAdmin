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



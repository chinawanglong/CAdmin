drop table if exists `c_admin`;
create table `c_admin`(
    `id` int(11) unsigned auto_increment,
    `username` varchar(20) not null comment'用户名',
    `password` varchar(80) not null comment'密码',
    `created` date default now(),
    primary key(`id`)
) engine=innodb auto_increment=1 default charset=utf8 comment'管理员表';

insert into c_admin values ('1', 'elliot', '123456', NOW()),('2', 'rookie', '123456', NOW());

drop table if exists `c_role`;
create table `c_role`(
    `id` int(11) unsigned auto_increment,
    `name` varchar(20) default null comment'角色名',
    `created` date default now(),
    primary key(`id`)
)engine=innodb default charset=utf8 comment'角色表';

insert into c_role values ('1', '系统管理员', NOW()),('2', '普通管理员', NOW()),('3', '游客', NOW());

drop table if exists `c_admin_role`;
create table `c_admin_role`(
    `id` int(11) unsigned auto_increment,
    `admin_id` int(11) not null,
    `role_id` int(11) not null,
    primary key(`id`)
)engine=innodb default charset=utf8 comment'管理员-角色关联表';

insert into c_admin_role values ('1','1','1'),('2','1','2'),('3','2','2'),('4','2','3');



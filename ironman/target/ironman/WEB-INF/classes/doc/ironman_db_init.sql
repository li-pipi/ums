-- ironman SQL
-- 创建并使用数据库：ironman_db
drop database if exists ironman_db;
create database ironman_db character set 'utf8mb4';
use ironman_db;

-- 创建角色信息表：sys_role
drop table if exists sys_role;
create table sys_role(
    id int(10) not null auto_increment comment '主键',
    name varchar(100) not null comment '名称',
    status int(2) not null default 1 comment '状态：0-禁用，1-启用',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='角色信息表';
insert into sys_role(name) values('超级管理员');

-- 菜单信息表：sys_menu
drop table if exists sys_menu;
create table sys_menu(
    id int(10) not null auto_increment comment '主键',
    pId int(100) comment '上级菜单',
    text varchar(100) not null comment '文本',
    url varchar(500) not null comment '链接地址',
    icon varchar(100) not null comment '菜单图标',
    status int(2) not null default 1 comment '状态：0-禁用，1-启用',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='菜单信息表';
insert into sys_menu(pId, text, url, icon) values(0,'系统管理','','fa fa-dashboard');
insert into sys_menu(pId, text, url, icon) values(0,'基础管理','','fa fa-gears');
insert into sys_menu(pId, text, url, icon) values(1,'用户管理','','fa fa-users');
insert into sys_menu(pId, text, url, icon) values(1,'角色管理','','fa fa-id-card-o');
insert into sys_menu(pId, text, url, icon) values(1,'我的信息','','fa fa-user-circle-o');
insert into sys_menu(pId, text, url, icon) values(2,'区域管理','','fa fa-map-marker');

-- 角色菜单中间表：sys_role_menu
drop table if exists sys_role_menu;
create table sys_role_menu(
    role_id int(10) comment '角色主键',
    menu_id int(10) comment '菜单主键'
)Engine=InnoDB charset='utf8mb4' comment='角色菜单中间表';
insert into sys_role_menu(role_id, menu_id) values(1,1);
insert into sys_role_menu(role_id, menu_id) values(1,2);
insert into sys_role_menu(role_id, menu_id) values(1,3);
insert into sys_role_menu(role_id, menu_id) values(1,4);
insert into sys_role_menu(role_id, menu_id) values(1,5);
insert into sys_role_menu(role_id, menu_id) values(1,6);

-- 用户信息表：sys_user
drop table if exists sys_user;
create table sys_user(
    id int(10) not null auto_increment comment '主键',
    name varchar(100) not null comment '姓名',
    cellphone varchar(100) not null comment '手机号码',
    password varchar(500) not null comment '登录密码',
    roleId int(10) not null comment '用户角色',
    idCard varchar(100) comment '身份证号码',
    email varchar(500) comment '电子邮件',
    avatar varchar(500) comment '头像',
    status int(2) not null default 1 comment '状态：0-禁用，1-启用',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='用户信息表';
insert into sys_user(name, cellphone, password, roleId) values('李皮皮', '19991327983', 'e10adc3949ba59abbe56e057f20f883e', 1);

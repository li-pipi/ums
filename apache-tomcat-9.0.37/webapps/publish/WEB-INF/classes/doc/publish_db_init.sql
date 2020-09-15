-- 创建并使用数据库：publish_db
drop database if exists publish_db;
create database publish_db character set 'utf8mb4';
use publish_db;

-- 信息类别表：sys_category
drop table if exists sys_category;
create table sys_category(
	id int(10) not null auto_increment comment '主键',
	name varchar(255) not null comment '类别名称',
	create_user int(10) not null comment '创建人',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	update_user int(10) not null comment '修改人',
	update_time timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
	primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='信息类别表';
insert into sys_category(name, create_user, update_user) values('今日头条', 1, 1);
insert into sys_category(name, create_user, update_user) values('娱乐体育', 1, 1);
insert into sys_category(name, create_user, update_user) values('文化教育', 1, 1);
insert into sys_category(name, create_user, update_user) values('科技趣闻', 1, 1);
insert into sys_category(name, create_user, update_user) values('糗事百科', 1, 1);

-- 信息详情表：sys_info
drop table if exists sys_info;
create table sys_info(
	id int(10) not null auto_increment comment '主键',
	category_id int(10) not null comment '信息分类',
	title varchar(255) not null comment '类别名称',
	sub_image varchar(500) comment '信息图片',
	context varchar(1000) comment '信息内容',
	create_user int(10) not null comment '创建人',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	update_user int(10) not null comment '修改人',
	update_time timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
	primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='信息详情表';

-- 用户信息表：sys_user
drop table if exists sys_user;
create table sys_user(
	id int(10) not null auto_increment comment '主键',
	name varchar(255) not null comment '用户姓名',
	cellphone varchar(255) not null unique comment '手机号码',
	password varchar(500) not null comment '登录密码',
	role int(2) not null default 2 comment '角色：0-管理，1-发布，2-用户',
	email varchar(500) comment '电子邮件',
	status int(2) not null default 1 comment '状态：0-禁用，1-启用',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	update_time timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
	primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='用户信息表';
insert into sys_user(name, cellphone, password, role, email) values('李鹏飞', '19991327983', '21232f297a57a5a743894a0e4a801fc3', 0, '1436172141@qq.com');
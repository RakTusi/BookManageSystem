CREATE DATABASE IF NOT EXISTS booksysdb;
USE booksysdb;
CREATE TABLE IF NOT EXISTS user
(
    id            int PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    username      varchar(16) NOT NULL UNIQUE COMMENT '用户名',
    password      varchar(60) NOT NULL COMMENT '密码',
    register_time DATETIME COMMENT '注册时间',
    status        int NOT NULL CHECK ( status>=0 and status<=2) COMMENT '身份，0为用户，1为管理员，2为超级管理员',
    name          varchar(20) NOT NULL COMMENT '真实姓名',
    birthdate     DATE COMMENT '出生日期',
    gender        tinyint NOT NULL DEFAULT 0 CHECK ( gender = 0 or gender = 1 ) COMMENT '性别，0为男性，1为女性',
    phone         varchar(16) NOT NULL COMMENT '联系方式',
    balance       bigint NOT NULL DEFAULT 0 COMMENT '余额',
    credit        int NOT NULL DEFAULT 100 CHECK ( credit >= 0 and credit <= 100) COMMENT '信用分，范围0-100',
    state         int NOT NULL CHECK ( state>=0 and state<=2) COMMENT '账号状态, 0正常使用, 1信用不良, 2禁用'
);

create table IF NOT EXISTS book
(
    id int primary key auto_increment comment '书本ID',
    book_info_id int not null comment '书目',
    register_time datetime not null comment '登记时间',
    registrant int not null comment '登记人',
    borrow_info_id int comment '当前借阅记录',
    state int not null default 0 check (state >=0 and state <=4) comment '书本状态，0为可借出，1已借出，2破损，3丢失，4不可借用'
);

create table IF NOT EXISTS default_log
(
    id int primary key auto_increment comment '记录ID',
    defaulter int not null comment '违约人',
    handler int not null comment '处理人',
    book int not null comment '书本',
    type int default 0 check(type>=0 and type<=3) comment '违约类型，0为逾期，1为书本丢失，2为书本破损，3为逾期且破损',
    reason varchar(200) comment '原因',
    create_time datetime not null comment '创建时间',
    fine int not null comment '押金',
    state int default 0 check(state>=0 and state<=2) comment '违约信息状态，0为未处理，1为已处理，2为取消'
);

create table IF NOT EXISTS borrow_info
(
    id int primary key auto_increment comment '记录ID',
    book_info_id int not null comment '借阅书目',
    book_id int not null comment '借阅书本',
    user_id int not null comment '申请用户',
    create_time datetime not null comment '申请日期',
    state int not null default 0 check (state >=0 and state <=6) comment '借阅状态',
    handler int not null comment '处理人',
    handle_time datetime comment '处理日期',
    return_time datetime comment '归还时间',
    is_renewed boolean default false comment '是否续借',
    days int default 15 comment '借阅天数'
);

create table IF NOT EXISTS book_info
(
    id int primary key auto_increment comment '书目ID',
    title varchar(60) not null comment '书名',
    author varchar(60) not null comment '作者',
    profile varchar(60) not null comment '简介',
    category varchar(60) not null comment '类别',
    edition varchar(60) not null comment '版本',
    press varchar(60) not null comment '出版社',
    publish_date date not null comment '出版日期',
    storage int not null comment '库存量',
    price int not null comment '价格',
    deposit int not null comment '建议押金',
    picture varchar(60) comment '图片'
);

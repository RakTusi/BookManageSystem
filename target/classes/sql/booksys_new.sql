create table book
(
    id             int auto_increment comment '书本ID'
        primary key,
    book_info_id   int           not null comment '书目',
    register_time  datetime      not null comment '登记时间',
    registrant     int           not null comment '登记人',
    state          int default 0 not null comment '书本状态，0为可借出，1已借出，2破损，3丢失，4不可借用',
    borrow_info_id int           null comment '目前借阅记录'
);

create table book_info
(
    id           int auto_increment comment '书目ID'
        primary key,
    title        varchar(60) not null comment '书名',
    author       varchar(60) not null comment '作者',
    profile      varchar(60) not null comment '简介',
    category     varchar(60) not null comment '类别',
    edition      varchar(60) not null comment '版本',
    press        varchar(60) not null comment '出版社',
    publish_date date        not null comment '出版日期',
    storage      int         not null comment '库存量',
    price        int         not null comment '价格',
    deposit      int         not null comment '建议押金',
    picture      varchar(60) null comment '图片'
);

create table borrow_info
(
    id           int auto_increment comment '记录ID'
        primary key,
    book_info_id int                   not null comment '借阅书目',
    book_id      int                   not null comment '借阅书本',
    user_id      int                   not null comment '申请用户',
    create_time  datetime              not null comment '申请日期',
    state        int        default 0  not null comment '借阅状态',
    handler      int                   not null comment '处理人',
    handle_time  datetime              not null comment '处理日期',
    return_time  datetime              null comment '归还时间',
    is_renewed   tinyint(1) default 0  null comment '是否续借',
    days         int        default 15 null comment '借阅天数'
);

create table default_log
(
    id          int auto_increment comment '记录ID'
        primary key,
    defaulter   int           not null comment '违约人',
    handler     int           not null comment '处理人',
    book        int           not null comment '书本',
    type        int default 0 null comment '违约类型，0为逾期，1为书本丢失，2为书本破损，3为逾期且破损',
    reason      varchar(200)  null comment '原因',
    create_time datetime      null comment '创建时间',
    fine        int           not null comment '罚金',
    state       int default 0 null comment '违约信息状态，0为未处理，1为已处理，2为取消'
);

create table user
(
    id            int auto_increment comment '用户ID'
        primary key,
    username      varchar(16)         not null comment '用户名',
    password      varchar(60)         not null comment '密码',
    register_time datetime            null comment '注册时间',
    status        int                 not null comment '身份，0为用户，1为管理员，2为超级管理员',
    name          varchar(20)         not null comment '真实姓名',
    birthdate     date                null comment '出生日期',
    gender        tinyint default 0   not null comment '性别，0为男性，1为女性',
    phone         varchar(16)         not null comment '联系方式',
    balance       bigint  default 0   not null comment '余额',
    credit        int     default 100 not null comment '信用分，范围0-100',
    state         int                 not null comment '账号状态, 0正常使用, 1信用不良, 2禁用',
    constraint username
        unique (username)
);


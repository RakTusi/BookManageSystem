package com.gdpu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private Integer id;
    private Integer bookInfo; //书目id
    private Date registerTime; //登记时间
    private Integer registrant; //登记人
    private Integer borrowInfoId; //目前借阅记录
    private Integer state; //状态

    private String title; //书名
    private String userName; //借阅人
    private Integer userId; //借阅人ID

    public static final Integer STATE_AVAILABLE = 0; //可借出
    public static final Integer STATE_BORROWED = 1; //已借出
    public static final Integer STATE_DAMAGED = 2; //破损
    public static final Integer STATE_LOST = 3; //丢失
    public static final Integer STATE_UNAVAILABLE = 4; //不可借出

}

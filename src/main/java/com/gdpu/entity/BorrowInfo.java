package com.gdpu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowInfo {
    private Integer id;
    private Integer bookInfo;
    private Integer book;
    private Integer user;
    private Date createTime;
    private Integer state;
    private Integer handler;
    private Date handleTime;
    private Date returnTime;
    private Integer isRenewed;
    private Integer days;

    private String title;
    private String userName;

    public static final Integer STATE_APPLYING = 0;
    public static final Integer STATE_BORROWING = 1;
    public static final Integer STATE_DAMAGED = 2;
    public static final Integer STATE_OVERDUE = 3;
    public static final Integer STATE_RETURNED = 4;
    public static final Integer STATE_LOST = 5;
    public static final Integer STATE_DENIED = 6;
}
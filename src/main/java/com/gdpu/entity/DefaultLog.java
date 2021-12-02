package com.gdpu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DefaultLog {
    private Integer id;
    private Integer defaulter;
    private Integer handler;
    private Integer book;
    private Integer type;
    private String reason;
    private Date createTime;
    private Integer fine;
    private Integer state;

    public static final Integer TYPE_RETURN_OVERDUE = 0;
    public static final Integer TYPE_BOOK_LOST = 1;
    public static final Integer TYPE_BOOK_DAMAGED = 2;
    public static final Integer TYPE_OVERDUE_AND_DAMAGED = 3;

    public static final Integer STATE_UNPAID = 0;
    public static final Integer STATE_PAID = 1;
    public static final Integer STATE_CANCELED = 2;
}

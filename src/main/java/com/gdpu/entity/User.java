package com.gdpu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date registerTime;
    private Integer status; //0为读者用户，1为管理员
    private String name;
    private Date birthdate;
    private Integer gender;
    private String phone;
    private Integer balance;
    private Integer credit;
    private Integer state;

    public static final int MALE = 0;
    public static final int FEMALE = 1;

    public static final int STATUS_USER = 0;
    public static final int STATUS_ADMIN = 1;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_BAD_CREDIT = 1;
    public static final int STATE_BANNED = 2;
}

package com.gdpu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BookInfo {
    private Integer id;
    private String title;
    private String author;
    private String profile;
    private String category;
    private String edition;
    private String press;
    private Date publishDate;
    private Integer storage;
    private Integer price;
    private Integer deposit;
    private String picture;
}

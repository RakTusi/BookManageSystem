package com.gdpu.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookInfoQuery extends Page{
    private Integer id;
    private String title;
    private String author;
    private String category;
    private String press;
    private Integer storage;
}

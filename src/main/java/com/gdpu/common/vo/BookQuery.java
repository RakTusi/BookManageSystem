package com.gdpu.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookQuery extends Page{
    private Integer id;
    private Integer bookInfoId;
    private String title;
}

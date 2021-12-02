package com.gdpu.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BorrowInfoQuery extends Page{
    private Integer id;
    private Integer bookInfoId;
    private Integer bookId;
    private String title;
    private Integer userId;
    private String userName;
    private Date createStartTime;
    private Date createEndTime;
    private Integer state;
}

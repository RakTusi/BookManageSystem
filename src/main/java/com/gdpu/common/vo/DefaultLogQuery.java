package com.gdpu.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class DefaultLogQuery extends Page{
    private Integer id;
    private Integer defaulter;
    private Integer book;
    private Integer type;
    private Date createStartTime;
    private Date createEndTime;
    private Integer state;
}

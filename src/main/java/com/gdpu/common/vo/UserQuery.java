package com.gdpu.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询User时所填参数类
 * 传到mapper里会自动识别
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQuery extends Page{
    private String name;
    private String username;
    private String phone;
    private Integer userid;
    private Integer status;
}

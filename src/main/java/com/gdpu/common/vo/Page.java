package com.gdpu.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable {
    private Integer page; //当前页
    private Integer limit; //获取记录数限制

    public Long getStart(){
        /*
        由于sql查询中limit a,b可以获得从a开始后的b条记录，所以这里Start是a，而limit是b
        则有page-1为起始位置，每页limit条记录，则可以获得从start到start+limit这个位置的记录
        */
        return (page - 1L) * limit;
    }
}

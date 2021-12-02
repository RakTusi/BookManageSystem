package com.gdpu.mapper;

import com.gdpu.common.vo.BookQuery;
import com.gdpu.common.vo.DefaultLogQuery;
import com.gdpu.entity.Book;
import com.gdpu.entity.BookInfo;
import com.gdpu.entity.DefaultLog;

import java.util.List;

public interface DefaultLogMapper {
    DefaultLog getDefaultLogById(Integer id);

    List<DefaultLog> find(DefaultLogQuery param);

    Long findNum(DefaultLogQuery param);

    int updateDefaultLog(DefaultLog param);

    int deleteDefaultLogsByIds(Integer[] ids);

    int addDefaultLog(DefaultLog param);
}

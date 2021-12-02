package com.gdpu.service;

import com.gdpu.common.vo.BookInfoQuery;
import com.gdpu.entity.Book;
import com.gdpu.entity.BookInfo;

import java.util.List;

public interface BookInfoService {
    BookInfo getBookInfoById(Integer id);

    List<BookInfo> find(BookInfoQuery param);

    Long findNum(BookInfoQuery param);

    int updateBookInfo(BookInfo param);

    int deleteBookInfosByIds(Integer[] ids);

    int addBookInfo(BookInfo param);
}

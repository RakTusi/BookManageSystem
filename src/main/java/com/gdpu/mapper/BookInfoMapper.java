package com.gdpu.mapper;

import com.gdpu.common.vo.BookInfoQuery;
import com.gdpu.common.vo.BookQuery;
import com.gdpu.entity.Book;
import com.gdpu.entity.BookInfo;
import com.gdpu.entity.BorrowInfo;

import java.util.List;

public interface BookInfoMapper {
    BookInfo getBookInfoById(Integer id);

    List<BookInfo> find(BookInfoQuery param);

    Long findNum(BookInfoQuery param);

    int updateBookInfo(BookInfo param);

    int deleteBookInfosByIds(Integer[] ids);

    int addBookInfo(BookInfo param);
}

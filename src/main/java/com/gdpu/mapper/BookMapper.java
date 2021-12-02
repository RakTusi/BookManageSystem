package com.gdpu.mapper;

import com.gdpu.common.vo.BookQuery;
import com.gdpu.entity.Book;

import java.util.List;

public interface BookMapper {
    Book getBookById(Integer id);

    List<Book> find(BookQuery param);

    Long findNum(BookQuery param);

    int updateBook(Book param);

    int deleteBooksByIds(Integer[] ids);

    int addBook(Book param);
}

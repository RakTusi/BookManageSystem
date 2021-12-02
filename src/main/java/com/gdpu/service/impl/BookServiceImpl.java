package com.gdpu.service.impl;

import com.gdpu.common.vo.BookQuery;
import com.gdpu.entity.Book;
import com.gdpu.mapper.BookInfoMapper;
import com.gdpu.mapper.BookMapper;
import com.gdpu.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookInfoMapper bookInfoMapper;

    @Override
    public Book getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<Book> find(BookQuery param) {
        return bookMapper.find(param);
    }

    @Override
    public Long findNum(BookQuery param) {
        return bookMapper.findNum(param);
    }

    @Override
    public int updateBook(Book param) {
        return bookMapper.updateBook(param);
    }

    @Override
    public int deleteBooksByIds(Integer[] ids) {
        return bookMapper.deleteBooksByIds(ids);
    }

    @Override
    public int addBook(Book param) {
        return bookMapper.addBook(param);
    }
}

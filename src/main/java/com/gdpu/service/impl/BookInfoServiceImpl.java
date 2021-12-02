package com.gdpu.service.impl;

import com.gdpu.common.vo.BookInfoQuery;
import com.gdpu.entity.Book;
import com.gdpu.entity.BookInfo;
import com.gdpu.mapper.BookInfoMapper;
import com.gdpu.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Resource
    private BookInfoMapper bookInfoMapper;

    @Override
    public BookInfo getBookInfoById(Integer id) {
        return bookInfoMapper.getBookInfoById(id);
    }

    @Override
    public List<BookInfo> find(BookInfoQuery param) {
        return bookInfoMapper.find(param);
    }

    @Override
    public Long findNum(BookInfoQuery param) {
        return bookInfoMapper.findNum(param);
    }

    @Override
    public int updateBookInfo(BookInfo param) {
        return bookInfoMapper.updateBookInfo(param);
    }

    @Override
    public int deleteBookInfosByIds(Integer[] ids) {
        return bookInfoMapper.deleteBookInfosByIds(ids);
    }

    @Override
    public int addBookInfo(BookInfo param) {
        return bookInfoMapper.addBookInfo(param);
    }
}

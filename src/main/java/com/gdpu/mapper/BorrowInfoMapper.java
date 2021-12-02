package com.gdpu.mapper;

import com.gdpu.common.vo.BookQuery;
import com.gdpu.common.vo.BorrowInfoQuery;
import com.gdpu.entity.Book;
import com.gdpu.entity.BookInfo;
import com.gdpu.entity.BorrowInfo;

import java.util.List;

public interface BorrowInfoMapper {
    BorrowInfo getBorrowInfoById(Integer id);

    List<BorrowInfo> find(BorrowInfoQuery param);

    Long findNum(BorrowInfoQuery param);

    int updateBorrowInfo(BorrowInfo param);

    int deleteBorrowInfosByIds(Integer[] ids);

    int addBorrowInfo(BorrowInfo param);
}

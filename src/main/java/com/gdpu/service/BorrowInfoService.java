package com.gdpu.service;

import com.gdpu.common.vo.BookQuery;
import com.gdpu.common.vo.BorrowInfoQuery;
import com.gdpu.entity.Book;
import com.gdpu.entity.BorrowInfo;

import java.util.List;

public interface BorrowInfoService {
    BorrowInfo getBorrowInfoById(Integer id);

    List<BorrowInfo> find(BorrowInfoQuery param);

    Long findNum(BorrowInfoQuery param);

    int updateBorrowInfo(BorrowInfo param);

    int deleteBorrowInfosByIds(Integer[] ids);

    int addBorrowInfo(BorrowInfo param);
}

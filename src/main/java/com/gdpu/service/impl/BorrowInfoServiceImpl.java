package com.gdpu.service.impl;

import com.gdpu.common.vo.BorrowInfoQuery;
import com.gdpu.entity.Book;
import com.gdpu.entity.BorrowInfo;
import com.gdpu.mapper.BorrowInfoMapper;
import com.gdpu.service.BorrowInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BorrowInfoServiceImpl implements BorrowInfoService {

    @Resource
    private BorrowInfoMapper borrowInfoMapper;

    @Override
    public BorrowInfo getBorrowInfoById(Integer id) {
        return borrowInfoMapper.getBorrowInfoById(id);
    }

    @Override
    public List<BorrowInfo> find(BorrowInfoQuery param) {
        return borrowInfoMapper.find(param);
    }

    @Override
    public Long findNum(BorrowInfoQuery param) {
        return borrowInfoMapper.findNum(param);
    }

    @Override
    public int updateBorrowInfo(BorrowInfo param) {
        return borrowInfoMapper.updateBorrowInfo(param);
    }

    @Override
    public int deleteBorrowInfosByIds(Integer[] ids) {
        return borrowInfoMapper.deleteBorrowInfosByIds(ids);
    }

    @Override
    public int addBorrowInfo(BorrowInfo param) {
        return borrowInfoMapper.addBorrowInfo(param);
    }
}

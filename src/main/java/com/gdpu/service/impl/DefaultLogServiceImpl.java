package com.gdpu.service.impl;

import com.gdpu.common.vo.DefaultLogQuery;
import com.gdpu.entity.DefaultLog;
import com.gdpu.mapper.DefaultLogMapper;
import com.gdpu.service.DefaultLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultLogServiceImpl implements DefaultLogService {

    @Resource
    private DefaultLogMapper defaultLogMapper;

    @Override
    public DefaultLog getDefaultLogById(Integer id) {
        return defaultLogMapper.getDefaultLogById(id);
    }

    @Override
    public List<DefaultLog> find(DefaultLogQuery param) {
        return defaultLogMapper.find(param);
    }

    @Override
    public Long findNum(DefaultLogQuery param) {
        return defaultLogMapper.findNum(param);
    }

    @Override
    public int updateDefaultLog(DefaultLog param) {
        return defaultLogMapper.updateDefaultLog(param);
    }

    @Override
    public int deleteDefaultLogsByIds(Integer[] ids) {
        return defaultLogMapper.deleteDefaultLogsByIds(ids);
    }

    @Override
    public int addDefaultLog(DefaultLog param) {
        return defaultLogMapper.addDefaultLog(param);
    }
}

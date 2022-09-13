package com.leayinge.service.Impl;

import com.github.pagehelper.PageHelper;
import com.leayinge.dao.LogDao;
import com.leayinge.domain.Log;
import com.leayinge.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public List<Log> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return logDao.findAll();
    }

    @Override
    public void addLog(Log log) throws Exception {
        logDao.addLog(log);
    }
}

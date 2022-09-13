package com.leayinge.service;

import com.leayinge.dao.LogDao;
import com.leayinge.domain.Log;

import java.util.List;

public interface LogService {

    public List<Log> findAll(int page, int size) throws Exception;

    public void addLog(Log log) throws Exception;

}

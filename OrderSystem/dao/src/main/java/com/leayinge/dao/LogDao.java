package com.leayinge.dao;

import com.leayinge.domain.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogDao {

    @Select("select * from `log`")
    public List<Log> findAll() throws Exception;

    @Insert("insert into `log`(`visit_time`,`username`,`ip`,`url`,`execution_time`,`method`) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void addLog(Log log) throws Exception;

}

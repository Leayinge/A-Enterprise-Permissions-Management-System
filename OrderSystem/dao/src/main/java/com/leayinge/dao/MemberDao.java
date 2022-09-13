package com.leayinge.dao;

import com.leayinge.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberDao {

    @Select("select * from `member`")
    List<Member> findAll() throws Exception;

    @Select("select * from `member` where `member_id`=#{memberId}")
    Member findById(Integer memberId) throws Exception;

}

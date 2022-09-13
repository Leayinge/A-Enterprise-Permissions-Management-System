package com.leayinge.service;

import com.leayinge.domain.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll() throws Exception;

    Member findById(Integer memberId) throws Exception;

}

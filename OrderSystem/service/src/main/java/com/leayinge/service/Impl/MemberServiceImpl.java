package com.leayinge.service.Impl;

import com.leayinge.dao.MemberDao;
import com.leayinge.domain.Member;
import com.leayinge.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao memberDao;

    public List<Member> findAll() throws Exception {
        return memberDao.findAll();
    }

    public Member findById(Integer memberId) throws Exception {
        return memberDao.findById(memberId);
    }

}

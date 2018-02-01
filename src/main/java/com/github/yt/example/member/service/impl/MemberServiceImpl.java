package com.github.yt.example.member.service.impl;


import com.github.yt.example.member.dao.MemberMapper;
import com.github.yt.example.member.domain.MemberT;
import com.github.yt.example.member.service.MemberService;
import com.github.yt.mybatis.service.impl.ServiceSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl extends ServiceSupport<MemberT, MemberMapper> implements MemberService {

    @Resource
    private MemberMapper memberMapper;


    @Override
    public MemberMapper getMapper() {
        return memberMapper;
    }
}

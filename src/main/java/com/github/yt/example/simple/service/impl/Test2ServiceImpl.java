package com.github.yt.example.simple.service.impl;


import com.github.yt.example.simple.dao.TestMapper;
import com.github.yt.example.member.domain.MemberT;
import com.github.yt.example.simple.service.Test2Service;
import com.github.yt.mybatis.service.impl.ServiceSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Test2ServiceImpl extends ServiceSupport<MemberT, TestMapper> implements Test2Service {

    @Resource
    private TestMapper testMapper;


    @Override
    public TestMapper getMapper() {
        return testMapper;
    }
}

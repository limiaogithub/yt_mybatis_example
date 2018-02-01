package com.github.yt.example.simple.service.impl;


import com.github.yt.example.simple.dao.TestMapper;
import com.github.yt.example.member.domain.MemberT;
import com.github.yt.example.simple.service.TestService;
import com.github.yt.mybatis.handler.QueryHandler;
import com.github.yt.mybatis.result.QueryResult;
import com.github.yt.mybatis.utils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public void save(MemberT memberT) {
        testMapper.save(memberT);
    }

    @Override
    public void update(MemberT memberT) {
        testMapper.updateForSelective(memberT);
    }

    @Override
    public MemberT find(Class clazz, Serializable id) {
        return testMapper.find(clazz, id);
    }

    @Override
    public void delete(Class clazz, Serializable id) {
        testMapper.delete(clazz, id);
    }

    @Override
    public List<MemberT> findAll(MemberT memberT, QueryHandler queryHandler) {
        return testMapper.findAll(MemberT.class, BeanUtils.getValueMap(queryHandler, memberT)
                .chainPutAll(queryHandler == null ? null : queryHandler.getExpandData()));
    }

    @Override
    public QueryResult<MemberT> getData(MemberT entity, QueryHandler queryHandler) {
        QueryResult<MemberT> qr = new QueryResult();
        qr.setRecordsTotal(testMapper.pageTotalRecord((Class<MemberT>) entity.getClass(), BeanUtils.getValueMap(queryHandler, entity)
                .chainPutAll(queryHandler == null ? null : queryHandler.getExpandData())));
        if (qr.getRecordsTotal() == 0) {
            qr.setData(new ArrayList<MemberT>());
            return qr;
        }
        qr.setData(testMapper.pageData((Class<MemberT>) entity.getClass(), BeanUtils.getValueMap(queryHandler, entity).chainPutAll
                (queryHandler == null ? null : queryHandler.getExpandData())));
        return qr;
    }
}

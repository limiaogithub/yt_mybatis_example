package com.github.yt.example.simple.service;

import com.github.yt.example.member.domain.MemberT;
import com.github.yt.mybatis.handler.QueryHandler;
import com.github.yt.mybatis.result.QueryResult;

import java.io.Serializable;
import java.util.List;

public interface TestService {

    /**
     * 保存会员
     *
     * @param memberT memberT
     */
    void save(MemberT memberT);

    /**
     * 更新会员
     *
     * @param memberT memberT
     */
    void update(MemberT memberT);

    /**
     * 通过id查找会员
     *
     * @param id 会员id
     * @return MemberT
     */
    MemberT find(Class clazz, Serializable id);

    /**
     * 删除会员
     *
     * @param id 会员id
     */
    void delete(Class clazz,Serializable id);

    /**
     * 查询会员集合
     *
     * @param memberT      memberT
     * @param queryHandler queryHandler
     * @return List<MemberT>
     */
    List<MemberT> findAll(MemberT memberT, QueryHandler queryHandler);

    /**
     * 查询会员分页集合
     *
     * @param memberT      memberT
     * @param queryHandler queryHandler
     * @return QueryResult<MemberT>
     */
    QueryResult<MemberT> getData(MemberT memberT, QueryHandler queryHandler);
}

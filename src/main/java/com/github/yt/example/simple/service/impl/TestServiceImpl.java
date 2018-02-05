package com.github.yt.example.simple.service.impl;


import com.github.yt.example.member.domain.MemberT;
import com.github.yt.example.simple.dao.TestMapper;
import com.github.yt.example.simple.service.TestService;
import com.github.yt.mybatis.handler.QueryHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public void test() {

        //测试save
        MemberT member = new MemberT().setUserName("测试name2").setPhone("18888888888").setAge(30);
        testMapper.save(member);

        //测试update
        member.setUserName("修改名称");
        testMapper.updateForSelective(member);

        //测试findById
        member = testMapper.find(MemberT.class, member.getMemberId());

        //测试查询，= 、in
        QueryHandler queryHandler = new QueryHandler();
        List<String> queryList = new ArrayList<>();
        queryList.add("18888888888");
        queryList.add("18888888889");

        queryHandler.addWhereSql("t.age=#{data.age1} and t.phone in" + QueryHandler.getInSql("phone1", queryList.size()));
        queryHandler.addExpandData("age1", 30);
        queryHandler.addExpandData("phone1", queryList.toArray());

        //测试findAll
        List<MemberT> list = testMapper.findAll(new MemberT(), queryHandler);

        //测试分页查询
        MemberT memberT = new MemberT();
        memberT.setPhone("18888888888");
        List<MemberT> list1 = testMapper.findAll(memberT, queryHandler.configPage().setStart(0).setLimit(10));
        Long total = testMapper.pageTotalRecord(memberT, queryHandler);
        System.out.println(total);

        //测试delete
        testMapper.delete(MemberT.class, member.getMemberId());
    }

}

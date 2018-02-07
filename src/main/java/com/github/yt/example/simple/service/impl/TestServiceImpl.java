package com.github.yt.example.simple.service.impl;


import com.github.yt.example.member.domain.MemberT;
import com.github.yt.example.simple.dao.TestMapper;
import com.github.yt.example.simple.service.TestService;
import com.github.yt.mybatis.handler.QueryHandler;
import com.github.yt.mybatis.handler.SQLJoinHandler;
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

        //测试findAll
        QueryHandler queryHandler = new QueryHandler();
        List<String> queryList = new ArrayList<>();
        queryList.add("18888888888");
        queryList.add("18888888889");
        queryHandler.addWhereSql("t.age=#{data.age1} and t.phone in" + QueryHandler.getInSql("data.phone1", queryList.size()));
        queryHandler.addExpandData("age1", 30);
        queryHandler.addExpandData("phone1", queryList.toArray());
        List<MemberT> list = testMapper.findAll(new MemberT(), queryHandler);

        //测试分页查询
        MemberT memberT = new MemberT();
        memberT.setPhone("18888888888");
        List<MemberT> list1 = testMapper.findAll(memberT, queryHandler.configPage().setStart(0).setLimit(10));
        Long total = testMapper.pageTotalRecord(memberT, queryHandler);
        System.out.println(total);

        //测试逻辑删除（需要你的domain继承BaseEntity）
        testMapper.logicDelete(MemberT.class, member.getMemberId());

        //测试delete
        testMapper.delete(MemberT.class, member.getMemberId());

        //测试级联查询，不建议复杂场景使用，不宜维护
        QueryHandler queryHandler2 = new QueryHandler();
        //queryHandler.configPage();
        List list2 = testMapper.findAll(new MemberT(), queryHandler2.addJoinHandle("cardt.*", SQLJoinHandler.JoinType.LEFT_OUTER_JOIN, "CardT cardt on t.memberId=cardt.memberId"));
        System.out.println(list2.size());
    }
}

package com.github.yt.example.simple.controller;

import com.github.yt.example.member.domain.MemberT;
import com.github.yt.example.simple.service.TestService;
import com.github.yt.mybatis.handler.QueryHandler;
import com.github.yt.mybatis.result.QueryResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @ApiOperation(value = "test")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void find() throws Exception {
        //测试add
        MemberT member = new MemberT().setUserName("测试name2").setPhone("18888888888");
        testService.save(member);

        //测试update
        member.setUserName("修改名称");
        testService.update(member);

        //测试findById
        member = testService.find(MemberT.class, member.getMemberId());

        //测试delete
        testService.delete(MemberT.class, member.getMemberId());

        //测试findAll
        List<MemberT> list = testService.findAll(new MemberT().setPhone("18888888888"), new QueryHandler().addWhereSql("t.deleteflag=1"));

        //测试getData,分页
        QueryResult<MemberT> queryResult = testService.getData(new MemberT().setPhone("18888888888"), new QueryHandler().configPage().setStart(0).setLimit(10));
    }

}

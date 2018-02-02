package com.github.yt.example.simple.controller;

import com.github.yt.example.member.domain.MemberT;
import com.github.yt.example.simple.service.Test2Service;
import com.github.yt.mybatis.handler.QueryHandler;
import com.github.yt.mybatis.result.QueryResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/test2")
public class Test2Controller {

    @Resource
    private Test2Service test2Service;

    @ApiOperation(value = "test")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void find() throws Exception {
        //测试add
        MemberT member = new MemberT().setUserName("测试name2").setPhone("18888888888");
        test2Service.save(member);

        //测试update
        member.setUserName("修改名称");
        test2Service.updateForSelective(member);

        //测试findById
        member = test2Service.find(MemberT.class, member.getMemberId());

        //测试delete
        test2Service.delete(MemberT.class, member.getMemberId());

        //测试findAll
        List<MemberT> list = test2Service.findAll(new MemberT().setPhone("18888888888"), new QueryHandler().addWhereSql("t.deleteflag=1"));

        //测试getData,分页
        QueryResult<MemberT> queryResult = test2Service.getData(new MemberT().setPhone("18888888888"), new QueryHandler().configPage());
    }

}

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
        testService.test();
    }

}

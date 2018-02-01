package com.github.yt.example.simple.handler;

import com.github.yt.mybatis.config.page.PageConvert;
import com.github.yt.mybatis.handler.QueryHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by limiao on 2018/2/1.
 */

@Service("myPageService")
public class MyPageService implements PageConvert {
    @Override
    public void convert(QueryHandler queryHandler, HttpServletRequest request) {
        System.out.println(123);
    }
}

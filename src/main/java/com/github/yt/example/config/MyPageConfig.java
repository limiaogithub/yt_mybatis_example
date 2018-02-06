package com.github.yt.example.config;


import com.github.yt.mybatis.config.page.PageConvert;
import com.github.yt.mybatis.handler.QueryHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 声明的接口必须叫@Service("ytPageConfig")</br></>
 * 如果您的项目中存在多种分页方式，您可以不执行queryHandler.configPage()，而是封装自己的方法后，set到queryHandler的start和limit方法中。
 */
//@Service("ytPageConfig")
//这里的目的是设置queryHandler中的start(从第几条读)和 limit（读取多少条）；如果不设置这个service，将默认读取CommonPageService中的配置
public class MyPageConfig implements PageConvert {

    @Override
    public void convert(QueryHandler queryHandler, HttpServletRequest request) {
        queryHandler.setStart(5);
        queryHandler.setLimit(8);
    }
}

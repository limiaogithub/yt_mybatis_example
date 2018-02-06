package com.github.yt.example.config;


import com.github.yt.mybatis.config.fields.FieldsDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 声明的接口必须叫@Service("ytFieldsConfig")</br></>
 */
//最常见的使用方式是从session中获取，如果想自定义，那么放开这个注释
//@Service("ytFieldsConfig")
public class MyFieldsConfig implements FieldsDefault {


    @Override
    public String getOperator() {
        return (String) getSessionAttr("Operator");
    }

    @Override
    public String getOperatorId() {
        return (String) getSessionAttr("OperatorId");
    }

    @Override
    public String getModifyOperator() {
        return (String) getSessionAttr("Operator");
    }

    @Override
    public String getModifyOperatorId() {
        return (String) getSessionAttr("OperatorId");
    }

    private Object getSessionAttr(String attr) {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession()
                .getAttribute(attr);
    }

}

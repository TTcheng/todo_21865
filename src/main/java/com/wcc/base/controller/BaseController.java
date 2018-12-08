package com.wcc.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
    @Autowired
    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    protected void validateEmpty(String name,Object val){
        if(StringUtils.isEmpty(val)){
            throw new RuntimeException("["+name+"]不能为空");
        }
    }

    protected HttpSession getSession(){
        return request.getSession();
    }
}

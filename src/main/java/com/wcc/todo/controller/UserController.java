package com.wcc.todo.controller;

import com.wcc.base.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String user_id,String password){
        // TODO
        return null;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(String user_id){
        // TODO
        return null;
    }
}

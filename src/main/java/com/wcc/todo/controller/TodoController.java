package com.wcc.todo.controller;

import com.wcc.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController extends BaseController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}

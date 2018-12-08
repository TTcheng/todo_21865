package com.wcc.todo.controller;

import com.wcc.base.controller.BaseController;
import com.wcc.base.utils.EncryptionUtils;
import com.wcc.base.utils.NumberUtils;
import com.wcc.todo.entity.User;
import com.wcc.todo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * 使用用户ID或用户名登录
     *
     * @param username 用户ID 或 用户名
     * @param password 密码
     * @return 待办事项管理页
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        super.validateEmpty("用户名或ID", password);
        super.validateEmpty("密码", password);
        User user;
        if (NumberUtils.isShort(username)) {
            user = (User) userService.queryUserById(Short.parseShort(username));
        } else {
            user = (User) userService.queryUserByName(username);
        }
        if (user != null && EncryptionUtils.validate(password, user.getPassword())) {
            throw new RuntimeException("密码错误！！！请重新输入。");
        }
        super.getSession().setAttribute("user",user);
        //form表单提交为post方法 ，使用重定向转为Get方法。另外防止重复提交
        return "redirect:/html/todo.html";
//        return "redirect:/error/unknown.html";
    }


    /**
     * 登出
     *
     * @param userId 用户id
     * @return 登录页面
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(String userId) {
        super.getSession().removeAttribute("user");
        return "/html/login.html";
    }
}

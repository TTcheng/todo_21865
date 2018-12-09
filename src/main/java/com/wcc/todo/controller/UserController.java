package com.wcc.todo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wcc.base.controller.BaseController;
import com.wcc.base.utils.EncryptionUtils;
import com.wcc.base.utils.NumberUtils;
import com.wcc.todo.entity.AppConst;
import com.wcc.todo.entity.TodoItem;
import com.wcc.todo.entity.User;
import com.wcc.todo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
     * @return 登陆信息
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, String> login(String username, String password) {
        Map<String, String> model = new HashMap<>();
        try {
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
            super.getSession().setAttribute("user", user);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, "登录失败");
            logger.error(AppConst.ERRORS,e);
        }
        return model;
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
        super.getSession().invalidate();
        return "/html/login.html";
    }

    /**
     * 获取当前用户的信息
     * @return User
     */
    @ResponseBody
    @GetMapping("/info")
    public User info(){
        User user = (User) getSession().getAttribute("user");
        return user;
    }

    @PostMapping("/update")
    public Map<String, Object> update(User newUser) {
        Map<String, Object> model = new HashMap<>();
        try {
            User user = (User) super.getSession().getAttribute("user");
            newUser.setCreationDate(null);
            newUser.setUserId(user.getUserId());
            userService.update(newUser);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.MESSAGE, AppConst.UPDATE_SUCCESS);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, AppConst.UPDATE_FAIL);
            logger.error(AppConst.ERRORS, e);
        }
        return model;
    }

    @ResponseBody
    @PostMapping("/insert")
    public Map<String,Object> insert(User entity){
        Map<String, Object> model = new HashMap<>();
        try {
            //to complete
            userService.insert(entity);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.MESSAGE, AppConst.INSERT_SUCCESS);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, AppConst.INSERT_FAIL);
            logger.error(AppConst.ERRORS, e);
        }
        return model;
    }
}

package com.wcc.todo.controller;

import com.wcc.base.controller.BaseController;
import com.wcc.base.exception.BusinessException;
import com.wcc.base.utils.EncryptionUtils;
import com.wcc.base.utils.NumberUtils;
import com.wcc.todo.entity.AppConst;
import com.wcc.todo.entity.User;
import com.wcc.todo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            if (user==null){
                throw new BusinessException("不存在此用户！");
            }
            if (!EncryptionUtils.validate(password, user.getPassword())) {
                throw new BusinessException("密码错误！！！请重新输入。");
            }
            super.getSession().setAttribute("user", user);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, e.getMessage());
            logger.error(AppConst.ERRORS, e);
        }
        return model;
    }


    /**
     * 登出
     * @return 登录页面
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        super.getSession().removeAttribute("user");
        super.getSession().invalidate();
        return "redirect:/html/login.html";
    }

    /**
     * 获取当前用户的信息
     *
     * @return User
     */
    @ResponseBody
    @GetMapping("/info")
    public User info() {
        User user = (User) getSession().getAttribute("user");
        return user;
    }

    @ResponseBody
    @PostMapping("/update")
    public Map<String, Object> update(User newUser) {
        Map<String, Object> model = new HashMap<>();
        try {
            super.validateEmpty("用户名", newUser.getUserName());
            super.validateEmpty("密码", newUser.getPassword());
            super.validateEmpty("年龄", newUser.getAge());
            super.validateEmpty("性别", newUser.getSex());
            //todo 合法性验证
            User user = (User) super.getSession().getAttribute("user");
            newUser.setCreationDate(user.getCreationDate());
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
    public Map<String, Object> insert(User entity) {
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

package com.wcc.todo.controller;

import com.wcc.base.controller.BaseController;
import com.wcc.base.entity.BaseEntity;
import com.wcc.todo.entity.AppConst;
import com.wcc.todo.entity.User;
import com.wcc.todo.service.TodoItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todo")
public class TodoController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TodoItemService todoItemService;

    @PostMapping("/queryPageList")
    public Map<String, Object> queryPageList(Integer begin,Integer end) {
        Map<String, Object> model = new HashMap<>();
        try {
            User user = (User) super.getSession().getAttribute("user");
            Map<String,Object> params = new HashMap<>();
            params.put("userId",user.getUserId());
            params.put("order","ASC");
            params.put("sort","TODO_ITEM_ID");
            params.put("begin",begin);
            params.put("end",end);
            List<BaseEntity> items = todoItemService.queryPageList(params);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.DATA, items);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, AppConst.QUERY_FAIL);
            logger.error(AppConst.ERRORS, e);
        }
        return model;
    }
}

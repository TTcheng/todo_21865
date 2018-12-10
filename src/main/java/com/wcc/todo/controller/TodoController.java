package com.wcc.todo.controller;

import com.wcc.base.controller.BaseController;
import com.wcc.base.entity.BaseEntity;
import com.wcc.todo.entity.AppConst;
import com.wcc.todo.entity.TodoItem;
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

    /**
     * 分页查询
     *
     * @param begin 开始条数
     * @param end   结束条数
     * @return items in model java.util.Map<String, Object>
     */
    @PostMapping("/queryPageList")
    public Map<String, Object> queryPageList(Integer begin, Integer end) {
        Map<String, Object> model = new HashMap<>();
        try {
            User user = (User) super.getSession().getAttribute("user");
            Map<String, Object> params = new HashMap<>();
            params.put("userId", user.getUserId());
            params.put("order", "ASC");
            params.put("sort", "TODO_ITEM_ID");
            params.put("begin", begin);
            params.put("end", end);
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

    /**
     * 更新指定待办事项
     *
     * @param entity 待办事项
     * @return
     */
    @PostMapping("/update")
    public Map<String, Object> update(TodoItem entity) {
        Map<String, Object> model = new HashMap<>();
        try {
            todoItemService.update(entity);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.MESSAGE, AppConst.UPDATE_SUCCESS);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, AppConst.UPDATE_FAIL);
            logger.error(AppConst.ERRORS, e);
        }
        return model;
    }

    /**
     * 插入一条待办事项
     *
     * @param entity 待办事项
     * @return
     */
    @PostMapping("/insert")
    public Map<String, Object> insert(TodoItem entity) {
        Map<String, Object> model = new HashMap<>();
        try {
            super.validateEmpty("待办标题",entity.getTodoItemTitle());
            super.validateEmpty("待办内容",entity.getTodoItemContent());
            super.validateEmpty("优先级",entity.getPriority());
            super.validateEmpty("编号",entity.getTodoItemId());
            //todo 合法性验证
            User currentUser = (User) getSession().getAttribute("user");
            entity.setUserId(currentUser.getUserId());
            todoItemService.insert(entity);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.MESSAGE, AppConst.INSERT_SUCCESS);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, AppConst.INSERT_FAIL);
            logger.error(AppConst.ERRORS, e);
        }
        return model;
    }

    /**
     * 删除一条待办事项
     *
     * @param todoItemId 待办事项编号
     * @return
     */
    @PostMapping("/delete")
    public Map<String, Object> delete(Short todoItemId) {
        Map<String, Object> model = new HashMap<>();
        try {
            todoItemService.delete(todoItemId);
            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.MESSAGE, AppConst.DELETE_SUCCESS);
        } catch (Exception e) {
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGE, AppConst.DELETE_FAIL);
            logger.error(AppConst.ERRORS, e);
        }
        return model;
    }
}

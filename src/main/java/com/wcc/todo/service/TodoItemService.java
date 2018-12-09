package com.wcc.todo.service;

import com.wcc.base.entity.BaseEntity;
import com.wcc.todo.dao.TodoItemDao;
import com.wcc.todo.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TodoItemService {

    @Autowired
    private TodoItemDao todoItemDao;

    public List<BaseEntity> queryPageList(Map<String, Object> params) {
        Short userid = (Short) params.get("userId");
        int total = todoItemDao.queryPageCount(userid);
        if (total > 0) {
            return todoItemDao.queryPageList(params);
        } else return new ArrayList<>();
    }

    public int insert(TodoItem item){
        return todoItemDao.insert(item);
    }

    public int update(TodoItem item){
        return todoItemDao.updateByPrimaryKeySelective(item);
    }

    public int delete(Short todoItemId){
        return todoItemDao.deleteByPrimaryKey(todoItemId);
    }
}

package com.wcc.todo.dao;

import com.wcc.todo.entity.TodoItem;
import org.springframework.stereotype.Component;

@Component
public interface TodoItemDao {
    int deleteByPrimaryKey(Short todoItemId);

    int insert(TodoItem record);

    int insertSelective(TodoItem record);

    TodoItem selectByPrimaryKey(Short todoItemId);

    int updateByPrimaryKeySelective(TodoItem record);

    int updateByPrimaryKey(TodoItem record);
}
package com.wcc.todo.mapper;

import com.wcc.todo.entity.TodoItem;

public interface TodoItemMapper {
    int deleteByPrimaryKey(Short todoItemId);

    int insert(TodoItem record);

    int insertSelective(TodoItem record);

    TodoItem selectByPrimaryKey(Short todoItemId);

    int updateByPrimaryKeySelective(TodoItem record);

    int updateByPrimaryKey(TodoItem record);
}
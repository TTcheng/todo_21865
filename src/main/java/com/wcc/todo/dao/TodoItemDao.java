package com.wcc.todo.dao;

import com.wcc.base.entity.BaseEntity;
import com.wcc.todo.entity.TodoItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TodoItemDao {
    int deleteByPrimaryKey(Short todoItemId);

    int insert(TodoItem record);

    int insertSelective(TodoItem record);

    TodoItem selectByPrimaryKey(Short todoItemId);

    int updateByPrimaryKeySelective(TodoItem record);

    int updateByPrimaryKey(TodoItem record);

    List<BaseEntity> queryPageList(Map<String,Object> map);

    int queryPageCount(Short userid);
}
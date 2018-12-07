package com.wcc.todo.mapper;

import com.wcc.todo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Short userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Short userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
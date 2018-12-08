package com.wcc.todo.dao;

import com.wcc.base.entity.BaseEntity;
import com.wcc.todo.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    int deleteByPrimaryKey(Short userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Short userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(String userName);
}
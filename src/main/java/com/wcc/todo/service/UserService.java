package com.wcc.todo.service;

import com.wcc.base.entity.BaseEntity;
import com.wcc.todo.dao.UserDao;
import com.wcc.todo.entity.TodoItem;
import com.wcc.todo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public BaseEntity queryUserById(Short userId){
        return userDao.selectByPrimaryKey(userId);
    }

    public BaseEntity queryUserByName(String userName){
        return userDao.selectByName(userName);
    }

    public int insert(User user){
        return userDao.insert(user);
    }

    public int update(User user){
        return userDao.updateByPrimaryKeySelective(user);
    }

    public int delete(Short userId){
        return userDao.deleteByPrimaryKey(userId);
    }

}

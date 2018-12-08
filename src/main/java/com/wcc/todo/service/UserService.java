package com.wcc.todo.service;

import com.wcc.base.entity.BaseEntity;
import com.wcc.todo.dao.UserDao;
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

}

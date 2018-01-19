package com.example.exam.service.impl;

import com.example.exam.annotation.BusinessAccess;
import com.example.exam.annotation.MutiDataSource;
import com.example.exam.dao.UserMapper;
import com.example.exam.domain.User;
import com.example.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @BusinessAccess("selectUserByName")
    @Override
    public User queryUserByName(String username, String password) {
//        return userMapper.queryUserByName(username, password);
        return userMapper.selectUserByName(username);

    }
}

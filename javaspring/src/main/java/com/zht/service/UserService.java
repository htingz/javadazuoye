package com.zht.service;

import com.zht.mapper.UserMapper;
import com.zht.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public user getUser(String username){
        return userMapper.selectByname(username);
    }
}
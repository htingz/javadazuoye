package com.zht.service;

import com.zht.mapper.CoachMapper;
import com.zht.pojo.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    @Autowired
    private CoachMapper coachMapper;

    public coach getUser(String username){
        return coachMapper.selectByname(username);
    }
}
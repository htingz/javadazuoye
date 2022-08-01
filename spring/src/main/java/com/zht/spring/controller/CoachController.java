package com.zht.spring.controller;

import com.zht.spring.config.Result;
import com.zht.spring.mapper.CoachMapper;
import com.zht.spring.mapper.UserMapper;
import com.zht.spring.pojo.coach;
import com.zht.spring.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/coach")
public class CoachController {
    @Resource
    UserMapper userMapper;
    @Resource
    CoachMapper coachMapper;
    @ResponseBody
    @PostMapping
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> login(@RequestBody coach coach){
        if (coachMapper.selectByname(coach.name)==null) {
            user user = userMapper.selectByname(coach.name);
            userMapper.updatecoach(coach.name);
            java.util.Date date = new java.util.Date();   // 获取当前时间
            java.sql.Date sql_date = new java.sql.Date(date.getTime());
            coach.setCreateDate(sql_date);
            coach.setModDate(sql_date);
            coach.setPhoto(user.phone);
            coach.setSex(user.sex);
            coachMapper.myinsert(coach);
        }else if(coachMapper.selectByname(coach.name)!=null){
            java.util.Date date = new java.util.Date();   // 获取当前时间
            java.sql.Date sql_date = new java.sql.Date(date.getTime());
            coach.setModDate(sql_date);
            coachMapper.updateByName(coach);
        }
        return Result.success("1");
    }

}

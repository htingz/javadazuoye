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
@RequestMapping("/admin")
public class AdminController {
    @Resource
    UserMapper userMapper;
    @Resource
    CoachMapper coachMapper;
    @ResponseBody
    @RequestMapping("/selectall")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> selectall(){
        return Result.success(userMapper.selectuser());
    }

    @ResponseBody
    @RequestMapping("/selectone")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> selectone(@RequestParam("name")String name){
        return Result.success(userMapper.selectByname(name));
    }

    @ResponseBody
    @RequestMapping("/deleteone")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> deleteone(@RequestParam("id")int id){
        userMapper.deleteById(id);
        return Result.success(userMapper.selectuser());
    }
}

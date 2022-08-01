package com.zht.controller;

import com.zht.config.Result;
import com.zht.mapper.CoachMapper;
import com.zht.mapper.UserMapper;
import com.zht.pojo.coach;
import com.zht.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")

public class UserController {

    @Resource
     UserMapper userMapper;

    @Resource
    CoachMapper coachMapper;

    @RequestMapping("/gallery")
    public String gallery(){
        return "redirect:http://127.0.0.1:9876/gallery";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public user save(@PathVariable int id){
        System.out.println(id);
        return userMapper.selectById(id);
    }

    @RequestMapping("/fitness_list")
    public String fitness(Model model){
        model.addAttribute("users",coachMapper.selectcoach());
        return "fitness_list";
    }

}

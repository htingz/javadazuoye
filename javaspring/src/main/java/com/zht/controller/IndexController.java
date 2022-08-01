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
@RequestMapping("/")
public class IndexController {
    @RequestMapping
    public String index(){
        return "index";
    }
}

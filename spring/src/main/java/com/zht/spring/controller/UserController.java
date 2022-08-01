package com.zht.spring.controller;

import com.zht.spring.config.Result;
import com.zht.spring.mapper.CoachMapper;
import com.zht.spring.mapper.JournalMapper;
import com.zht.spring.mapper.OrderMapper;
import com.zht.spring.mapper.UserMapper;
import com.zht.spring.pojo.coach;
import com.zht.spring.pojo.journal;
import com.zht.spring.pojo.order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")

public class UserController {

    @Resource
     UserMapper userMapper;

    @Resource
    CoachMapper coachMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    JournalMapper journalMapper;



    @RequestMapping("/gallery")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result gallery(){
        System.out.println("bug");
        return Result.error("11","请重新登录");
    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public user save(@PathVariable int id){
//        System.out.println(id);
//        return userMapper.selectById(id);
//    }
    @ResponseBody
    @RequestMapping("/fitness_list")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<List<coach>> fitness(){
        return Result.success(coachMapper.selectcoach());
    }
    @RequestMapping("/fitnessselect")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<coach> fitnessselect(@RequestParam("name") String name){
        return Result.success(coachMapper.selectByname(name));
    }
    @RequestMapping("/query")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<List<order>> query(HttpServletResponse response, HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("users");
        return Result.success(orderMapper.selectByname(name));
    }

    @RequestMapping("/evaluate")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<List<order>> evaluate(HttpServletResponse response, HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("users");
        return Result.success(orderMapper.selectByname(name));
    }
    @RequestMapping("/evaluate2")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<List<order>> evaluate2(@RequestParam("name") String name,HttpServletResponse response, HttpServletRequest request){
        String name2 = (String) request.getSession().getAttribute("users");
        return Result.success(orderMapper.selectByname2(name,name2));
    }

    @RequestMapping("/diary")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<List<journal>> diary(HttpServletResponse response, HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("users");
        System.out.println(name);
        int id = userMapper.selectid(name);

        return Result.success(journalMapper.selectByuserid(id));
    }

    @RequestMapping("/paid")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<List<order>> paid(HttpServletResponse response, HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("users");
        return Result.success(orderMapper.selectByname3(name));

    }

    @RequestMapping("/fitnessyu")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> fitnessyu(@RequestParam("name") String name,HttpServletResponse response, HttpServletRequest request){
        String name2 = (String) request.getSession().getAttribute("users");
        order order = new order();
        order.setUserid(userMapper.selectid(name2));
        order.setUsername(name2);
        order.setCoachid(coachMapper.selectid(name));
        order.setCoachname(name);
        order.setPayment(0);
        order.setOrderid(orderMapper.myselectCount()+1);
        orderMapper.myinsert(order);
        coachMapper.updateisclass(name);
        return Result.success(orderMapper.selectorder());

    }

    @RequestMapping("/zifu")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> zifu(@RequestParam("id") int id,HttpServletResponse response, HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("users");
        orderMapper.updatepayment(id);
        return Result.success(orderMapper.selectByname(name));

    }

    @RequestMapping("/pingjia")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> pingjia(@RequestParam("content")String content,@RequestParam("id") int id,HttpServletResponse response, HttpServletRequest request){
        orderMapper.updatepingjia(id,content);
        return Result.success();

    }
    @RequestMapping("/zifu2")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> zifu2(@RequestParam("id") int id,HttpServletResponse response, HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("users");
        orderMapper.updatepayment(id);
        return Result.success(orderMapper.selectByname3(name));

    }

    @RequestMapping("/xieriji")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?>xieriji(@RequestParam("content") String content,HttpServletResponse response, HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("users");
        journal journal = new journal();
        journal.setContent(content);
        java.util.Date date = new java.util.Date();   // 获取当前时间
        java.sql.Date sql_date = new java.sql.Date(date.getTime());
        journal.setCreatedate(sql_date);
        journal.setUserid(userMapper.selectid(name));
        journalMapper.myinsert(journal);
        return Result.success("1");

    }
}

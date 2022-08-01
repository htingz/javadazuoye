package com.zht.spring.controller;

import com.zht.spring.config.Result;
import com.zht.spring.mapper.CoachMapper;
import com.zht.spring.mapper.UserMapper;
import com.zht.spring.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/user")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> login(@RequestParam("username") String name, @RequestParam("password") String password,@RequestParam("image") String image, HttpServletResponse response, HttpServletRequest request){
        user user = userMapper.selectByname(name);
        if (!image.equals(request.getSession().getAttribute("captcha")))return Result.error("11","验证码不正确");
        if(user.getPassword().equals(password)&&image.equals(request.getSession().getAttribute("captcha"))) {
            request.getSession().setAttribute("users",name);
            return Result.success("1");
        }
        return Result.error("1","用户名或密码不正确");
    }

    @ResponseBody
    @RequestMapping("/coach")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> logingcoach(@RequestParam("username") String name,@RequestParam("password") String password,@RequestParam("image") String image, HttpServletResponse response, HttpServletRequest request){
        user user = userMapper.selectByname(name);
        if (!image.equals(request.getSession().getAttribute("captcha")))return Result.error("11","验证码不正确");
        if(user.getPassword().equals(password)&&user.getCoach()!=null &&user.getCoach()==1&&image.equals(request.getSession().getAttribute("captcha"))) {
            request.getSession().setAttribute("users",name);
            return Result.success("1");
        }
        return Result.error("1","用户名或密码不正确");
    }

    @ResponseBody
    @RequestMapping("/admin")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> logingadmin(@RequestParam("username") String name,@RequestParam("password") String password,@RequestParam("image") String image, HttpServletResponse response, HttpServletRequest request){

        if (!image.equals(request.getSession().getAttribute("captcha")))return Result.error("11","验证码不正确");
        if("root".equals(name)&&"745645910".equals(password)&&image.equals(request.getSession().getAttribute("captcha"))) {
            request.getSession().setAttribute("users",name);
            return Result.success("1");
        }
        return Result.error("1","用户名或密码不正确");
    }

    @ResponseBody
    @RequestMapping("/regist")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> logingregist(@RequestParam("username") String name,@RequestParam("password") String password,@RequestParam("sex") String sex, HttpServletResponse response, HttpServletRequest request){
        if (userMapper.selectByname(name)!=null){
            return Result.error("1","用户已存在");
        }
        user user = new user();
        user.setSex(sex);
        user.setPassword(password);
        user.setUsername(name);
        user.setCoach(0);
        userMapper.insert(user);

        return Result.success();
    }

    @ResponseBody
    @RequestMapping("/out")
    @CrossOrigin(origins="http://127.0.0.1:9876",allowCredentials = "true")
    public Result<?> logout(HttpServletResponse response, HttpServletRequest request){
        request.getSession().removeAttribute("users");
        System.out.println("1:"+request.getSession().getAttribute("users"));
        return Result.success("1");
    }

}

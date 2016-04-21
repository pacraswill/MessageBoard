package com.board.controller;

import com.board.domain.UserEntity;
import com.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 29979 on 2015/12/18.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    //登陆
    @RequestMapping(value = "login")
    //@ResponseBody
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        ModelMap modelMap) {
        boolean loginJudge = userService.login(name, password);
        //boolean judge = userService.login(request,response);
        modelMap.addAttribute("currentUser", name);
        if (loginJudge) {
            List<UserEntity> userList = userService.showUsers(name);
            modelMap.addAttribute("userList", userList);
            return "LoginSuccess";
        } else {
            return "LoginFail";
        }
    }

//
//    //浩哥给改的
//    public ModelAndView login() {
//        ModelAndView view = new ModelAndView();
//        view.setViewName("");
//        view.addObject("username", "nicholas");
//        return view;
//    }



    //注册   跳到注册页面
    @RequestMapping("register")
    public String register(){
        return "register";
    }


    //注册处理
    @RequestMapping("registerHandler")
    public String registerHandler(@RequestParam("name") String name,
                                  @RequestParam("password") String password) {
        boolean judge = userService.register(name, password);
        if (judge) {
            return "RegisterSuccess";
        } else {
            return "RegisterFail";
        }
    }
}

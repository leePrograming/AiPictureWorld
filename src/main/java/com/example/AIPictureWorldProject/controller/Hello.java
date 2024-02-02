package com.example.AIPictureWorldProject.controller;

import com.example.AIPictureWorldProject.model.entity.User;
import com.example.AIPictureWorldProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class Hello {


    UserService userService;

    @Autowired
    public Hello(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/main")
    public String test(){
        return "mainPage";

    }

    @RequestMapping("/video")
    public String viewVideo()
    {
        System.out.println("password: test");
        return "videos";
    }

    @RequestMapping("/helloWorld")
    public String getHelloWorld()
    {
        System.out.println("password: test");
     return "helloWorld";
    }



    @RequestMapping("/getName")
    public @ResponseBody List<User> getName(Model model){

        List<User> actor = new ArrayList<>();

        System.out.println("testzz");

        actor = userService.findByUserInfo();
        model.addAttribute("user",actor);
        return actor;
    }

    @RequestMapping("/getId")
    public String getId(){

        userService.getId();
        return "mainPage";
    }

}

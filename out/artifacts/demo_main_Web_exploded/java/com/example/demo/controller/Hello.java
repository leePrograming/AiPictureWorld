package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class Hello {

    @RequestMapping("/test")
    public String test(){
        return "index";

    }

    @RequestMapping("/helloWorld")
    public String getHelloWorld()
    {
        System.out.println("password: test");
     return "helloWorld2";
    }

}

package com.example.AIPictureWorldProject.controller;

import com.example.AIPictureWorldProject.dto.UserDto;
import com.example.AIPictureWorldProject.service.UserService;
import com.example.AIPictureWorldProject.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LoginController {

    static Logger logger = LoggerFactory.getLogger(LoginController.class);

    UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }


    @RequestMapping("/login")
    public String userLogin(HttpServletRequest request, HttpServletResponse response) {

        return "loginPage";
    }

    @RequestMapping("/userSignIn")
    @ResponseBody
    public String userSignIn(UserDto userDto){

        String message = "";

        if(!userService.checkLoginIdDuplicate(userDto.getId())) {
            try {
                userService.signUpUser(userDto);
                logger.info("success");
                message = "success";
            }catch (Exception e){
                logger.warn("아이디를 등록하는데 문제가 발생하였습니다.");
                message = "errorCode(1)";
            }
        }
        else{
            logger.info("아이디가 중복되었습니다.");
            message = "errorCode(2)";
        }



        return message;
    }

    @RequestMapping("/logInUser")
    @ResponseBody
    public String logInUser(UserDto userDto){

        String message = "";

        if(!userService.checkLoginIdDuplicate(userDto.getId())) {
            try {
                userService.signUpUser(userDto);
                logger.info("success");
                message = "success";
            }catch (Exception e){
                logger.warn("아이디를 등록하는데 문제가 발생하였습니다.");
                message = "errorCode(1)";
            }
        }
        else{
            logger.info("아이디가 중복되었습니다.");
            message = "errorCode(2)";
        }



        return message;
    }


}

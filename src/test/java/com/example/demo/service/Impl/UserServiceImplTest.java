package com.example.demo.service.Impl;


import com.example.AIPictureWorldProject.dto.UserDto;
import com.example.AIPictureWorldProject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplTest {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImplTest(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Test
    public void setUserRepository(UserDto userDto){
        //UserDto userDto = new UserDto();
        //userRepository.save(userDto);
        userDto.setUserNo(1);
        userDto.setId("test1");
        userDto.setPassword("test1234");
        userDto.setAdminYN(1);
        userDto.setCreateId("test");
        //userDto.setCreateDt("date");

        userRepository.save(userDto.toEntity());
    }


}

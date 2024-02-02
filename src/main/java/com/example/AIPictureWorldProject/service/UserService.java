package com.example.AIPictureWorldProject.service;

import com.example.AIPictureWorldProject.dto.UserDto;
import com.example.AIPictureWorldProject.model.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findByUserInfo();

    public boolean checkLoginIdDuplicate(String id);

    public void getId();

    public void signUpUser(UserDto userDto);
}

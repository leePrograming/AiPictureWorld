package com.example.AIPictureWorldProject.service;

import com.example.AIPictureWorldProject.model.entity.User;
import com.example.AIPictureWorldProject.dto.UserDto;
import com.example.AIPictureWorldProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public UserDto userServiceMethod(String str) {
        UserDto userDto = new UserDto();

        return userDto;
    }

    //로그인 아이디 중복체크
    public boolean checkLoginIdDuplicate(String id){
        return userRepository.existsById(id);
    }


    //유저 정보 가져오기
    public List<User> findByUserInfo(){

        // create, read, update, delete
        //    userRepository.save(new User()); //User 생성하고 저장.
        //    System.out.println(" >>> " + userRepository.findAll());

        List<User> user = userRepository.findAll();
        System.out.println(user.size());
        System.out.println(user.get(0).getPassword());

        return user;
    }

    //아이디 찾기
    public void getId(){

        // create, read, update, delete
        //userRepository.save(new User()); //User 생성하고 저장.
        System.out.println(" >>> " + userRepository.findAll());
    }

    //회원 가입 기능
    public void signUpUser(UserDto userDto){
        System.out.println(" >>> " + userDto.getUserNo());
        User user = null;
        user = userDto.toEntity();

        System.out.println("id : " + user.getId());
        System.out.println("email : " + user.getEmail());
        System.out.println("password : " + user.getPassword());
        System.out.println("datetime : " + user.getCreateDt());
        userRepository.save(user);
    }

}

package com.example.AIPictureWorldProject.repository;

import com.example.AIPictureWorldProject.dto.UserDto;
import com.example.AIPictureWorldProject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//
//    public Optional<User> findAllBy();
//
//    public int findById();

    public boolean existsById(String id);

    public Optional<User> findById(String id);

    public void save(UserDto userDto);



}

package com.example.AIPictureWorldProject.dto;

import com.example.AIPictureWorldProject.model.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    public UserDto(User entity){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userNo;
    @NotBlank(message = "로그인 아이디를 입력하지 않았습니다.")
    private String id;
    @NotBlank(message="비밀번호를 입력하지 않았습니다.")
    private String password;
    @NotBlank(message="이메일을 입력하지 않았습니다.")
    private String email;
    private int adminYN;
    private String createDt;
    private String createId;

    public User toEntity() {
        return User.builder()
                .userNo(this.userNo)
                .id(this.id)
                .password(this.password)
                .email(this.email)
                .adminYN(this.adminYN)
                .createId(this.createId)
                .build();
    }



}

package com.example.AIPictureWorldProject.model.entity;

import com.example.AIPictureWorldProject.model.builder.CommonBuilder;
import com.example.AIPictureWorldProject.dto.UserDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
public class User {


    @Id
    @Column
    private int userNo;
    @Column
    private String id;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private int adminYN;

    @Column
    @CreatedBy
    private String createId;
    @CreatedDate
    @Column
    private LocalDateTime createDt;

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public Integer getUserNo() {
        return userNo;
    }

@Builder
    private User(int userNo, String id, String password, String email, int adminYN, String createId) {
        this.userNo = userNo;
        this.id = id;
        this.password = password;
        this.email = email;
        this.adminYN = adminYN;
        this.createId = createId;
    }
}

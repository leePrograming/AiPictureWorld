package com.example.AIPictureWorldProject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Data
public class PagingDto {

    public PagingDto(){

    }

    @Id
    private int userNo;
    private String id;
    private String password;
    private int adminYN;
    private String createDt;
    private String createId;

}

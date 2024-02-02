package com.example.AIPictureWorldProject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Data
public class TagDto {

    public TagDto(){

    }

    @Id
    private int tagNo;
    private String tagNm;

}

package com.example.AIPictureWorldProject.dto;


import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImgBoardDto {

    public ImgBoardDto(){

    }

    public ImgBoardDto(int boardNo, String boardNm) {
        this.boardNo = boardNo;
        this.boardNm = boardNm;
    }

    @Id
    private int boardNo;

    private int fileId;

    private String boardNm;

    private String dimension;

    private String format;

    private String views;

    private String createDt;

    private String createId;

}

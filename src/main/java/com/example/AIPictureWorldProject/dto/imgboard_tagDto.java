package com.example.AIPictureWorldProject.dto;

import jakarta.persistence.JoinColumn;

public class imgboard_tagDto {

    public imgboard_tagDto(){

    }


    @JoinColumn(name="boardNo")
    private int boardNo;
    @JoinColumn(name="tagNo")
    private int tagNo;

}

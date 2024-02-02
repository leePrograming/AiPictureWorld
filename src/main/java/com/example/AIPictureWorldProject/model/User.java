package com.example.AIPictureWorldProject.model;

import org.springframework.data.annotation.Id;

public class User {


    @Id
    private int userNo;
    private String id;
    private String password;
    private int adminYN;
    private String createDt;
    private String createId;



}

package com.example.AIPictureWorldProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class AiPictureWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiPictureWorldApplication.class, args);
    }

}

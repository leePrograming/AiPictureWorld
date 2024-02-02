package com.example.AIPictureWorldProject.controller;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileDownloadController {

    private static final String FILE_DIRECTORY = "C:\\Users\\abc12\\IdeaProjects\\demo\\src\\main\\resources\\static\\img";

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Path filePath = Paths.get(FILE_DIRECTORY, fileName);
        Resource resource;

        try {
            resource = new org.springframework.core.io.UrlResource(filePath.toUri());
        } catch (IOException e) {
            // 파일을 찾을 수 없는 경우 예외 처리
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
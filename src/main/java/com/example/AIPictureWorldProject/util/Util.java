package com.example.AIPictureWorldProject.util;

import com.example.AIPictureWorldProject.dto.AttachFilesDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Util{

public void fnFileDownLoad(AttachFilesDto attachFilesDto, HttpServletRequest request, HttpServletResponse response){

    System.out.println(attachFilesDto.getLocalPath());
    System.out.println(attachFilesDto.getRealFileNm());
    // globals.properties
    File file = new File("C:\\Users\\abc12\\IdeaProjects\\demo\\src\\main\\resources\\static" +attachFilesDto.getLocalPath(), attachFilesDto.getRealFileNm());
    try {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

        //User-Agent : 어떤 운영체제로  어떤 브라우저를 서버( 홈페이지 )에 접근하는지 확인함
        String header = request.getHeader("User-Agent");
        String fileName;

        if ((header.contains("MSIE")) || (header.contains("Trident")) || (header.contains("Edge"))) {
            //인터넷 익스플로러 10이하 버전, 11버전, 엣지에서 인코딩
            fileName = URLEncoder.encode(attachFilesDto.getRealFileNm(), StandardCharsets.UTF_8);
        } else {
            //나머지 브라우저에서 인코딩
            fileName = new String(attachFilesDto.getRealFileNm().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        }
        //형식을 모르는 파일첨부용 contentType
        response.setContentType("application/octet-stream");
        //다운로드와 다운로드될 파일이름
        response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
        try {    //파일복사
            FileCopyUtils.copy(in, response.getOutputStream());
            in.close();
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }

}


}




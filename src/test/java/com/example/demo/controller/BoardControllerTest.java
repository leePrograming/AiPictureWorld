package com.example.demo.controller;


import com.example.AIPictureWorldProject.controller.BoardController;
import com.example.AIPictureWorldProject.service.BoardServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//어노테이션을 통해 builder없이 주입 가능
@WebMvcTest(BoardController.class)
@SpringBootTest
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BoardServiceImpl boardService;
//http://localhost:8080/search
    @Test
    @DisplayName("Board 데이터 가져오기")
    @Disabled
    void getBoardDataTest2() throws Exception{

        PageRequest pageable = PageRequest.of(0, 10);

        // give : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        given(boardService.searchPhotoData("화분", pageable));//.willReturn(new Page<ImgBoard>());

        int boardNo = 1;

        // andExpect는 기대하는 값이 나왓는지 확인 할 수 있는 메소드
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andDo(print());

        verify(boardService).readBoardData();
    }

    @Test
    @DisplayName("Board 데이터 가져오기")
    void getBoardDataTest() throws Exception{

        PageRequest pageable = PageRequest.of(0, 10);

        boardService.searchPhotoData("화분", PageRequest.of(0,10));
        int boardNo = 1;

        System.out.println("test3");
        // andExpect는 기대하는 값이 나왓는지 확인 할 수 있는 메소드
        //mockMvc.perform(get("/search"))
        //        .andExpect(status().isOk())
        //        .andDo(print());

        //verify(boardService).readBoardData();
    }


    @Test
    @DisplayName("Board 상세 데이터 가져오기")
    @Disabled
    void getBoardDetailDataTest() throws Exception{

        PageRequest pageable = PageRequest.of(0, 10);

        // give : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        given(boardService.readPhotoDetailData(1));//.willReturn(new Optional<ImgBoard>());

        int boardNo = 1;

        // andExpect는 기대하는 값이 나왓는지 확인 할 수 있는 메소드
        mockMvc.perform(get("/searchRelate"))
                .andExpect(status().isOk())
                .andDo(print());

        verify(boardService).readPhotoDetailData(boardNo);
    }



}

package com.example.AIPictureWorldProject.dao;

import com.example.AIPictureWorldProject.repository.BoardRepository;
import com.example.AIPictureWorldProject.model.entity.ImgBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ImgBoardDAOImpl implements ImgBoardDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(ImgBoardDAOImpl.class);
    @Autowired
    private BoardRepository boardRepository;

    public List<ImgBoard> readBoardData(){

        List<ImgBoard> board = boardRepository.findAll();

        return board;
    }

    public Optional<ImgBoard> readPhotoDetailData(int id){

        Optional<ImgBoard> board = boardRepository.findById(id);

        return board;
    }

    public Page<ImgBoard> paging(Pageable pageable){

        return boardRepository.findAll(pageable);
    }


    @Override
    public Page<ImgBoard> searchPhotoData(String boardNm, Pageable pageable){

        Page<ImgBoard> board = boardRepository.findByboardNmContaining(boardNm,pageable);


        return board;
    }

    @Override
    public List<ImgBoard> searchRelatedPhotoData(String tag){

        List<ImgBoard> board = null;
        board = boardRepository.findByTagContaining(tag);

        return board;
    }



}

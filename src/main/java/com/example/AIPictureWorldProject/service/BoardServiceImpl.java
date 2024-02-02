package com.example.AIPictureWorldProject.service;

import com.example.AIPictureWorldProject.model.entity.AttachFiles;
import com.example.AIPictureWorldProject.model.entity.ImgBoard;
import com.example.AIPictureWorldProject.dao.AttachFilesDAO;
import com.example.AIPictureWorldProject.dao.ImgBoardDAO;
import com.example.AIPictureWorldProject.repository.AttachFilesRepository;
import com.example.AIPictureWorldProject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    private BoardRepository boardRepository;

    private ImgBoardDAO imgBoardDAOImpl;
    private AttachFilesDAO attachFilesDAOImpl;

    @Autowired
    public void BoardServiceImpl(ImgBoardDAO imgBoardDAOImpl){
        this.imgBoardDAOImpl = imgBoardDAOImpl;
    }

    @Autowired
    public void BoardServiceImpl(AttachFilesDAO attachFilesDAOImpl){
        this.attachFilesDAOImpl = attachFilesDAOImpl;
    }
    private AttachFilesRepository attachFilesRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository,AttachFilesRepository attachFilesRepository){
        this.boardRepository = boardRepository;
        this.attachFilesRepository = attachFilesRepository;
    }


    public List<ImgBoard> readBoardData(){

        List<ImgBoard> board = imgBoardDAOImpl.readBoardData();

        return board;
    }

    public Optional<ImgBoard> readPhotoDetailData(int id){

        Optional<ImgBoard> board = imgBoardDAOImpl.readPhotoDetailData(id);

        return board;
    }

    public Page<ImgBoard> searchPhotoData(String boardNm, Pageable pageable){

        Page<ImgBoard> board = imgBoardDAOImpl.searchPhotoData(boardNm,pageable);

        return board;
    }

    public List<ImgBoard> searchRelatePhotoData(String tag){

        List<ImgBoard> board = imgBoardDAOImpl.searchRelatedPhotoData(tag);

        return board;
    }


    public Page<ImgBoard> paging(Pageable pageable){

        return imgBoardDAOImpl.paging(pageable);
    }

    public Optional<AttachFiles> readAttachFilesData(int fileId){

        Optional<AttachFiles> file = attachFilesDAOImpl.readAttachFilesData(fileId);

        return file;
    }

}

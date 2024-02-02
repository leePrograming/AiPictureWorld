package com.example.AIPictureWorldProject.dao;

import com.example.AIPictureWorldProject.model.entity.ImgBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ImgBoardDAO {

    List<ImgBoard> readBoardData();
    Optional<ImgBoard> readPhotoDetailData(int id);

    Page<ImgBoard> paging(Pageable pageable);


    Page<ImgBoard> searchPhotoData(String boardNm, Pageable pageable);
    List<ImgBoard> searchRelatedPhotoData(String tag);

}

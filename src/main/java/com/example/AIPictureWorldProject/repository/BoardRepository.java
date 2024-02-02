package com.example.AIPictureWorldProject.repository;

import com.example.AIPictureWorldProject.model.entity.ImgBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<ImgBoard, Integer> {

    //Page<ImgBoard> findByUserOrderByIdDesc(ImgBoard imgBoard, Pageable pageable);


    //@Query(value = "select img.boardNo as boardNo,attFiles.localPath as localPath,attFiles.realFileNm as realFileNm,img.boardNm as boardNm,img.dimension as dimension,img.views as views, img.createDt as createDt from ImgBoard as img inner join AttachFiles attFiles on img.fileId = attFiles.fileId where attFiles.fileId = img.fileId")
    //@Query(value = "select img.boardNo as boardNo,img.boardNm as boardNm,img.dimension as dimension,img.views as views, img.createDt as createDt from ImgBoard as img")
    @Query(value = "select ImgBoard.boardNo,ImgBoard.boardNm,ImgBoard.dimension,ImgBoard.views, ImgBoard.createDt,AttachFiles.localPath,AttachFiles.realFileNm from ImgBoard as ImgBoard inner JOIN AttachFiles as AttachFiles ON ImgBoard.fileId = AttachFiles.fileId where ImgBoard.boardNm like %:boardNm%")
    Page<ImgBoard> findByboardNmContaining(@Param("boardNm") String boardNm, Pageable pageable);

    List<ImgBoard> findByTagContaining(String tag);


    //Page<ImgBoard> findByboardNmContaining(String boardNm,Pageable pageable);


}

package com.example.AIPictureWorldProject.service;

import com.example.AIPictureWorldProject.model.entity.AttachFiles;
import com.example.AIPictureWorldProject.model.entity.ImgBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardService {

List<ImgBoard> readBoardData();

  Page<ImgBoard> paging(Pageable pageable);
  @Query(value = "select ImgBoard.boardNo,ImgBoard.boardNm,ImgBoard.dimension,ImgBoard.views, ImgBoard.createDt,AttachFiles.localPath,AttachFiles.realFileNm from ImgBoard as ImgBoard inner JOIN AttachFiles as AttachFiles ON ImgBoard.fileId = AttachFiles.fileId where ImgBoard.boardNm like %:id%")
  Optional<ImgBoard> readPhotoDetailData(@Param("boardNm") int id);

  //public Page<ImgBoard> searchPhotoData(String boardNm,Pageable pageable);

  Optional<AttachFiles> readAttachFilesData(int fileId);


  Page<ImgBoard> searchPhotoData(String boardNm, Pageable pageable);
  List<ImgBoard> searchRelatePhotoData(String tag);

}

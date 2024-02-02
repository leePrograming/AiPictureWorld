package com.example.AIPictureWorldProject.controller;

import com.example.AIPictureWorldProject.model.entity.AttachFiles;
import com.example.AIPictureWorldProject.util.Util;
import com.example.AIPictureWorldProject.model.entity.ImgBoard;
import com.example.AIPictureWorldProject.dto.AttachFilesDto;
import com.example.AIPictureWorldProject.dto.ImgBoardDto;
import com.example.AIPictureWorldProject.dto.UserDto;
import com.example.AIPictureWorldProject.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class BoardController {


    BoardService boardService;


//    static Logger logger = Logger

    static Logger logger = LoggerFactory.getLogger(BoardController.class);
    @Autowired
    public BoardController(BoardService boardService){
    this.boardService = boardService;
    }


    @RequestMapping("/getImgBoardData")
    public @ResponseBody List<ImgBoard> getName(Model model){

        List<ImgBoard> board = new ArrayList<>();

        System.out.println("testzz");

        board = boardService.readBoardData();
        model.addAttribute("user",board);
        return board;
    }

    @RequestMapping("/photoDetail")
    public String viewPhotoDetail(Model model, @RequestParam int boardNo){

        logger.info("boardNo :" + boardNo);
        Optional<ImgBoard> board = boardService.readPhotoDetailData(boardNo);
        logger.info("getFileId : " + board.get().getFileId());

        int fileId = board.get().getFileId();
        Optional<AttachFiles> file = boardService.readAttachFilesData(fileId);
        model.addAttribute("photoDetail",board.get());
        model.addAttribute("attachFile",file.get());

        return "photo-detail";
    }


    @RequestMapping("/search")
    @ResponseBody
    public Page<ImgBoard> boardSearch(Model model, ImgBoardDto imgBoardDto, @PageableDefault(sort = "boardNo", direction = Sort.Direction.DESC)Pageable pageable){

        //System.out.println(model.getAttribute());
        logger.info("1 : " +imgBoardDto.getBoardNm());
        logger.info("test Log");

        Page<ImgBoard> board = boardService.searchPhotoData(imgBoardDto.getBoardNm(), pageable);
        //System.out.println("2 : " +board.get);
        //int fileId = board.get().findFirst().get().getFileId();
        //Optional<AttachFiles> file = boardService.readAttachFilesData(fileId);

        model.addAttribute("hasNext",board.hasNext());
        model.addAttribute("attachFile",board.get());

        return board;
    }

    @RequestMapping("/searchRelate")
    @ResponseBody
    public List<ImgBoard> boardSearchRelate(Model model, ImgBoardDto imgBoardDto, @PageableDefault(sort = "boardNo", direction = Sort.Direction.DESC)Pageable pageable){


        String tagNm = null;
        String[] tagArr = null;
        List<ImgBoard> imgBoard = null;
        List<ImgBoard> mergedList = new ArrayList<>();

        logger.info("1 : " +imgBoardDto.getBoardNo());

        int boardNo= imgBoardDto.getBoardNo();

        //imgBoard값을 불러온다.
        //Page<ImgBoard> board = imgBoardDAO.searchPhotoData(imgBoardDto.getBoardNo(), pageable);
        Optional<ImgBoard> board = boardService.readPhotoDetailData(boardNo);
        tagNm = board.get().getTag();
        //태그를 arr에 입력
        tagArr = tagNm.split(",");

        logger.info("board.boardNo : " + board.get().getBoardNo());
        logger.info("board.boardNm : " + board.get().getBoardNm());
        logger.info("tagNm : " + tagNm);


        for(int i=0; i<tagArr.length; i++){
            logger.info("tagArr[i] : " + tagArr[i]);
            mergedList.addAll(boardService.searchRelatePhotoData(tagArr[i]));
        }
        Set<ImgBoard> setMergedList = new HashSet<>(mergedList);
        imgBoard = new ArrayList<>(setMergedList);
        //자신의 boardNo 삭제
        imgBoard.removeIf(entity -> boardNo == entity.getBoardNo());


        logger.info("mergedList size : " + imgBoard.size());
        for(int i=0; i<imgBoard.size(); i++){
            logger.info("mergedList.getBoardNo["+ i +"] : " + imgBoard.get(i).getBoardNo());
            logger.info("mergedList.getTag["+ i +"] : " + imgBoard.get(i).getTag());
        }
        //System.out.println("2 : " +board.get);
        //int fileId = board.get().findFirst().get().getFileId();
        //Optional<AttachFiles> file = boardService.readAttachFilesData(fileId);

        //model.addAttribute("attachFile",board.get());

        return imgBoard;
    }

    @RequestMapping("/paging")
    @ResponseBody
    public Page<ImgBoard> paging(Model model,UserDto userDto, @PageableDefault(sort = "boardNo", direction = Sort.Direction.DESC)Pageable pageable){


        Page<ImgBoard> board = boardService.paging(pageable);

        int fileId = board.get().findFirst().get().getFileId();
        Optional<AttachFiles> file = boardService.readAttachFilesData(fileId);
        logger.info("test :" + board.hasNext());
        model.addAttribute("hasNext",board.hasNext());
        model.addAttribute("hasNext2","zza");
        model.addAttribute("attachFile",board.get());

        return board;
    }

    @RequestMapping("/downLoad")
    public void fileDownLoad(@RequestParam("fileId")int fileId, HttpServletRequest request, HttpServletResponse response){

        Optional<AttachFiles> attachFiles = boardService.readAttachFilesData(fileId);
        AttachFilesDto fileDto = new AttachFilesDto();
        logger.info(attachFiles.get().getLocalPath());
        logger.info(attachFiles.get().getFileNm());
        fileDto.setRealFileNm(attachFiles.get().getRealFileNm());
        fileDto.setLocalPath(attachFiles.get().getLocalPath());

        Util util = new Util();
        util.fnFileDownLoad(fileDto,request,response);

    }

}

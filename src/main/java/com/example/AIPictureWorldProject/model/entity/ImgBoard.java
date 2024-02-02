package com.example.AIPictureWorldProject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Entity(name="ImgBoard")
@Table(name="ImgBoard")
@EntityListeners(AuditingEntityListener.class)
@Getter
public class ImgBoard {

    public ImgBoard(){

    }

    public ImgBoard(int boardNo, String boardNm){
        this.boardNo = boardNo;
        this.boardNm = boardNm;
    }
    @Id @Column(name="BoardNo")
    private int boardNo;
    @Column(name="FileId")
    private int fileId;
    @Column(name="BoardNm")
    private String boardNm;
    @Column(name="Dimension")
    private String dimension;
    @Column(name="Format")
    private String format;
    @Column(name="Tag")
    private String tag;
    @Column(name="Views")
    private String views;
    @Column(name="CreateDt")
    private String createDt;
    @Column(name="CreateId")
    private String createId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImgBoard that = (ImgBoard) o;
        return boardNo == that.boardNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardNo);
    }

}

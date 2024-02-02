package com.example.AIPictureWorldProject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name="AttachFiles")
@Entity(name="AttachFiles")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class AttachFiles {


    @Id
    @Column(name="FileId")
    private int fileId;
    @Column(name="LocalPath")
    private String localPath;
    @Column(name="RealFileNm")
    private String realFileNm;
    @Column(name="FileNm")
    private String fileNm;
    @Column(name="FileSize")
    private int fileSize;
    @Column(name="CreateDt")
    private String createDt;
    @Column(name="CreateId")
    private String createId;

}

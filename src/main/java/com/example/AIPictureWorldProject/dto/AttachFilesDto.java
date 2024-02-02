package com.example.AIPictureWorldProject.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class AttachFilesDto {

    @Column
    private int fileId;
    @Column
    private String localPath;
    @Column
    private String RealFileNm;
    @Column
    private String FileNm;
    @Column
    private int FileSize;
    @Column
    private String CreateDt;
    @Column
    private String CreateId;



}

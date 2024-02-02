package com.example.AIPictureWorldProject.dao;

import com.example.AIPictureWorldProject.model.entity.AttachFiles;

import java.util.Optional;

public interface AttachFilesDAO {

    Optional<AttachFiles> readAttachFilesData(int fileId);

}

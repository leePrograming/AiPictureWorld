package com.example.AIPictureWorldProject.dao;

import com.example.AIPictureWorldProject.model.entity.AttachFiles;
import com.example.AIPictureWorldProject.repository.AttachFilesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachFilesDAOImpl implements AttachFilesDAO {


    private final Logger LOGGER = LoggerFactory.getLogger(AttachFilesDAOImpl.class);
    @Autowired
    private final AttachFilesRepository attachFilesRepository;

    public AttachFilesDAOImpl(AttachFilesRepository attachFilesRepository){
        this.attachFilesRepository = attachFilesRepository;
    }

    public Optional<AttachFiles> readAttachFilesData(int fileId){

        Optional<AttachFiles> file = attachFilesRepository.findById(fileId);

        return file;
    }

}

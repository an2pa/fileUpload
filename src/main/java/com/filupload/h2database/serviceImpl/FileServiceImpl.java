package com.filupload.h2database.serviceImpl;

import com.filupload.h2database.POJO.File;
import com.filupload.h2database.POJO.Test;
import com.filupload.h2database.dao.FileDao;
import com.filupload.h2database.dao.TestDao;
import com.filupload.h2database.service.FileService;
import com.filupload.h2database.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;
    @Override
    public ResponseEntity<String> uploadDocument(MultipartFile file) throws IOException {
        File file1=fileDao.save(File.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(FileUtils.compressFile(file.getBytes())).build());
        if(file1!=null) {
            return new ResponseEntity<>("successfull", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("unuccessfull", HttpStatus.BAD_REQUEST);
        }

    public byte[] downloadDocument(String fileName){
       Optional<File> dbFileData = fileDao.findByName(fileName);
        byte[] files=FileUtils.decompressFile(dbFileData.get().getFileData());
        return files;
    }


}

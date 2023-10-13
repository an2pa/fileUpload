package com.filupload.h2database.service;

import com.filupload.h2database.POJO.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    ResponseEntity<String> uploadDocument(MultipartFile file) throws IOException;
    byte[]  downloadDocument(String fileName);

}

package com.filupload.h2database.rest;

import com.filupload.h2database.POJO.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(path="/file")
public interface FileRest {
    @PostMapping(path = "/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile test);

    @GetMapping(path = "/download/{fileName}")
    public ResponseEntity<?> downloadDocument(@PathVariable String fileName);

}

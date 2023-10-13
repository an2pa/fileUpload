package com.filupload.h2database.restImpl;

import com.filupload.h2database.POJO.Test;
import com.filupload.h2database.rest.FileRest;
import com.filupload.h2database.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileRestImpl implements FileRest {

    @Autowired
    FileService fileService;
    @Override
    public ResponseEntity<String> uploadDocument(MultipartFile test) {
        try {
            fileService.uploadDocument(test);
            return new ResponseEntity<>("sucessfull",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("unsucessfull",HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<?> downloadDocument(String fileName) {
        try {
            byte[] fileData = fileService.downloadDocument(fileName);

            HttpHeaders headers = new HttpHeaders();

            if (fileName.toLowerCase().endsWith(".xlsx") || fileName.toLowerCase().endsWith(".xls")) {
                // For Excel files, set the content type to Excel
                headers.setContentType(MediaType.valueOf("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            } else {
                // For other files (e.g., images), use a generic binary content type
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            }

            // Suggest a filename for the downloaded file
            headers.set("Content-Disposition", "attachment; filename=" + fileName);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

}

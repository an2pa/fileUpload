package com.filupload.h2database.Implementation;




import com.filupload.h2database.POJO.File;
import com.filupload.h2database.POJO.FileDao;
import com.filupload.h2database.utils.FileUtils;
import com.sun.tools.javac.Main;
import de.mnet.dispatcher.rule.dto.RuleEngineContentDto;
import de.mnet.dispatcher.rule.rest.RuleApi;
import org.apache.tomcat.util.digester.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api")

public class RuleApiImpl implements RuleApi {



    @Autowired
    FileDao fileDao;


    public static final Logger logger = LoggerFactory.getLogger(Main.class);


    @Override
    public ResponseEntity<RuleEngineContentDto> ruleEngineFileUpload(MultipartFile file, RuleEngineContentDto metadata) {
        RuleEngineContentDto test = new RuleEngineContentDto();
        File fileTest = new File();

        try {
            fileTest.setName(file.getOriginalFilename());
            fileTest.setFileData(FileUtils.compressFile(file.getBytes()));
            fileTest.setType(file.getContentType());
            fileDao.save(fileTest);
            return new ResponseEntity<RuleEngineContentDto>(test,HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error occurred during file upload:{}", e.getMessage());
        }
        test.setName("Unsuccess");
        return new ResponseEntity<RuleEngineContentDto>(test,HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<Resource> ruleEngineFileDownload(Integer fileId) {
        Optional<File> dbFileData = fileDao.findById(fileId);

    }
}

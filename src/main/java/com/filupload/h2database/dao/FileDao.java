package com.filupload.h2database.dao;

import com.filupload.h2database.POJO.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDao extends JpaRepository<File, Long> {
    Optional<File> findByName(String fileName);
}

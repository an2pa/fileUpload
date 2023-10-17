package com.filupload.h2database.POJO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FileDao extends JpaRepository<File, Long> {
}

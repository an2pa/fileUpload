package com.filupload.h2database.dao;

import com.filupload.h2database.POJO.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<Test, Integer> {
}

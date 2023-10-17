package com.filupload.h2database.POJO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FileDao extends JpaRepository<File, Long> {

    @Query(value = "SELECT f from File as f where (:name is null or f.name = :name)")
    public List<File> findFilteredFiles(@Param("name") String name);
}
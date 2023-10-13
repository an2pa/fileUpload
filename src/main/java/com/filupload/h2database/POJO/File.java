package com.filupload.h2database.POJO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="FileData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @Lob
    @Column(name = "filedata", length = 1000)
    private byte[] fileData;
}

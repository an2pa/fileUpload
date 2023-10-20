package com.filupload.h2database.POJO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productNo;
    private String customerName;
    private String customerLocation;
    private String customerContactNumber;
}

//http://localhost:8080/api/getOrders?productNo=1&page=0&size=5
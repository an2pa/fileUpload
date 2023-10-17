package com.filupload.h2database.POJO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {

    @Query(value = "SELECT o from Order as o where (:productNo is null or o.productNo = :productNo)")
    public Page<Order> findFilteredOrders(@Param("productNo") String productNo, Pageable pageable);

}

package com.filupload.h2database.FilterApi;

import com.filupload.h2database.POJO.File;

import com.filupload.h2database.POJO.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequestMapping(path="/api")
public interface FilterRest {
    @GetMapping(path = "/file")
    public ResponseEntity<List<File>> getFilteredDocuments(@RequestParam(value = "name", required = false) String name);

    @PostMapping(path = "/orders")
    public ResponseEntity<String> postOorders();

    @GetMapping(path = "/getOrders")
    public Page<Order> getOrders(@RequestParam(value = "productNo", required = false) String productNo, @RequestParam int page, @RequestParam int size);

}
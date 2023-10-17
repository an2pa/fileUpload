package com.filupload.h2database.FilterApi;

import com.filupload.h2database.POJO.File;
import com.filupload.h2database.POJO.FileDao;
import com.filupload.h2database.POJO.Order;
import com.filupload.h2database.POJO.OrderDao;
import com.filupload.h2database.utils.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FilterApiImpl implements FilterRest{

    @Autowired
    FileDao fileDao;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDao orderDao;

    @Override
    public ResponseEntity<List<File>> getFilteredDocuments(String name) {
        System.out.println("USAO");
       List<File> testList= fileDao.findFilteredFiles(name);
       return  new ResponseEntity<>(testList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> postOorders() {
        System.out.println("USAO");
        orderService.seedFakeOrders(100, 4);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @Override
    public Page<Order> getOrders(String productNo, int page, int size) {
        Pageable pr = PageRequest.of(page, size);
        return orderDao.findFilteredOrders(productNo, pr);
    }
}

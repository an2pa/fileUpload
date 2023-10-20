package com.filupload.h2database.FilterApi;

import com.filupload.h2database.utils.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeedApiImpl implements SeedApi{
    @Autowired
    OrderService orderService;

    @Override
    public ResponseEntity<String> seedOrders() {
        System.out.println("USAO");
        orderService.seedFakeOrders(100, 4);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}

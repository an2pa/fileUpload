package com.filupload.h2database.FilterApi;

import com.filupload.h2database.POJO.Order;
import com.filupload.h2database.POJO.OrderDao;
import de.mnet.dispatcher.rule.dto.GetFilteredOrders200Response;
import de.mnet.dispatcher.rule.rest.GetOrdersApi;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrdersApiImpl implements GetOrdersApi {
    @Autowired
    OrderDao orderDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<GetFilteredOrders200Response> getFilteredOrders(Integer page, Integer size, String productNo) {
        Pageable pr = PageRequest.of(page, size);
        Page<Order> ordersPage = orderDao.findFilteredOrders(productNo, pr);
        List<de.mnet.dispatcher.rule.dto.Order> convertedOrders = new ArrayList<>();
        for (Order order : ordersPage.getContent()) {
            de.mnet.dispatcher.rule.dto.Order convertedOrder = modelMapper.map(order, de.mnet.dispatcher.rule.dto.Order.class);
            convertedOrders.add(convertedOrder);
        }
        GetFilteredOrders200Response response = new GetFilteredOrders200Response();
        response.setContent(convertedOrders);
        response.setTotalPages(ordersPage.getTotalPages());
        response.setTotalElements(convertedOrders.size());
        response.setLast(ordersPage.isLast());
        response.setSize(ordersPage.getSize());
        response.setNumber(ordersPage.getNumber());

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<GetFilteredOrders200Response> getFilteredOrders(Integer page, Integer size) {
        Pageable pr = PageRequest.of(page, size);
        Page<Order> ordersPage = orderDao.findAll(pr);
        List<de.mnet.dispatcher.rule.dto.Order> convertedOrders = new ArrayList<>();
        for (Order order : ordersPage.getContent()) {
            de.mnet.dispatcher.rule.dto.Order convertedOrder = modelMapper.map(order, de.mnet.dispatcher.rule.dto.Order.class);
            convertedOrders.add(convertedOrder);
        }
        GetFilteredOrders200Response response = new GetFilteredOrders200Response();
        response.setContent(convertedOrders);
        response.setTotalPages(ordersPage.getTotalPages());
        response.setTotalElements(convertedOrders.size());
        response.setLast(ordersPage.isLast());
        response.setSize(ordersPage.getSize());
        response.setNumber(ordersPage.getNumber());

        return ResponseEntity.ok(response);
    }

}

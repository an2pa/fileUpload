package com.filupload.h2database.FilterApi;

import com.filupload.h2database.POJO.Order;
import com.filupload.h2database.POJO.OrderDao;
import de.mnet.dispatcher.rule.dto.GetFilteredOrders200Response;
import de.mnet.dispatcher.rule.rest.GetOrderByIdApi;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GetByIdController implements GetOrderByIdApi {

    @Autowired
    OrderDao orderDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<de.mnet.dispatcher.rule.dto.Order> getOrderById(Integer orderId) {
        Optional<Order> order= orderDao.findById((long) orderId);
        de.mnet.dispatcher.rule.dto.Order convertedOrder = modelMapper.map(order, de.mnet.dispatcher.rule.dto.Order.class);
        return ResponseEntity.ok(convertedOrder);
    }
}

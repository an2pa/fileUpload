package com.filupload.h2database.utils;

import com.filupload.h2database.POJO.Order;
import com.filupload.h2database.POJO.OrderDao;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    private final Faker faker;
    public OrderService(OrderDao orderRepository) {
        this.faker = new Faker();
    }

    public void seedFakeOrders(int numberOfOrders, int productNoRange) {

        if (productNoRange <= 0 || productNoRange > 5) {
            throw new IllegalArgumentException("Product number range must be between 1 and 5.");
        }
        for (int i = 0; i < numberOfOrders; i++) {
            int productNo = (i % productNoRange) + 1;
            Order fakeOrder = Order.builder()
                    .productNo(String.valueOf(productNo))
                    .customerName(faker.name().fullName())
                    .customerLocation(faker.address().cityName())
                    .customerContactNumber(faker.phoneNumber().cellPhone())
                    .build();
            orderDao.save(fakeOrder);
        }
    }
}
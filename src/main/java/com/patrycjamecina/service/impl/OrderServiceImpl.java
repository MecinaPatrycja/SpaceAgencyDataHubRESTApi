package com.patrycjamecina.service.impl;
import com.patrycjamecina.model.OrderLineItem;
import com.patrycjamecina.model.OrderProduct;
import com.patrycjamecina.model.Product;
import com.patrycjamecina.repository.OrderRepository;
import com.patrycjamecina.repository.ProductRepository;
import com.patrycjamecina.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public void prepareOrder(OrderProduct order) {
        LocalDateTime now = LocalDateTime.now();
        order.setOrderDate(convertToDateViaSqlTimestamp(now));
        double orderLinePrice;
        double sumOfOrderLinePrice = 0;
        for (OrderLineItem oli : order.getOrderLineItems()) {
            Optional<Product> product = productRepository.findById(oli.getProductId());
            double productPrice = product.get().getProductPrice();
            orderLinePrice = oli.getQuantity() * productPrice;
            sumOfOrderLinePrice += orderLinePrice;
            order.setTotalOrderAmount(sumOfOrderLinePrice);
            oli.setOrderProduct(order);
        }
        orderRepository.save(order);
    }

    @Override
    public List<OrderProduct> getTheOrderHistory() {
        return orderRepository.findAll();
    }

    private Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
}
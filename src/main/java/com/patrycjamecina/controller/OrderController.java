package com.patrycjamecina.controller;
import com.patrycjamecina.model.OrderProduct;
import com.patrycjamecina.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;

    @PostMapping("/prepare")
    public void prepareOrder(@RequestBody OrderProduct order) {
        orderService.prepareOrder(order);
    }

    @GetMapping("/history")
    public List<OrderProduct> getTheOrderHistory() {
        return orderService.getTheOrderHistory();
    }
}

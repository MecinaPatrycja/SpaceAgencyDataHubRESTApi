package com.patrycjamecina.service;
import com.patrycjamecina.model.OrderProduct;

import java.util.List;
public interface OrderService {
    void prepareOrder(OrderProduct order);
    List<OrderProduct> getTheOrderHistory();
}

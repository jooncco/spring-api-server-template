package com.templates.springapiserverasync.order.service;

import com.templates.springapiserverasync.order.dto.Order;
import java.util.List;

public interface OrderService {
    Order getOrder(String id);

    List<Order> getOrders(String userId);

    int insertOrder(Order order);

    Order updateOrder(String id, Order order);

    int deleteOrder(String id);
}

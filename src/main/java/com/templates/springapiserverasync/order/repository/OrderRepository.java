package com.templates.springapiserverasync.order.repository;

import com.templates.springapiserverasync.order.dto.Order;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {
    Order getOrder(String id);

    List<Order> getOrders();

    int insertOrder(Order order);

    Order updateOrder(String id, Order order);

    int deleteOrder(String id);
}

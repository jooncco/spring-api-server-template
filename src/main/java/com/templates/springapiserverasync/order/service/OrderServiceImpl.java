package com.templates.springapiserverasync.order.service;

import com.templates.springapiserverasync.order.dto.Order;
import com.templates.springapiserverasync.order.repository.OrderRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order getOrder(String id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public List<Order> getOrders(String userId) {
        return orderRepository.getOrders(userId);
    }

    @Override
    public int insertOrder(Order order) {
        return orderRepository.insertOrder(order);
    }

    @Override
    public Order updateOrder(String id, Order order) {
        return orderRepository.updateOrder(id, order);
    }

    @Override
    public int deleteOrder(String id) {
        return orderRepository.deleteOrder(id);
    }
}

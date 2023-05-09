package com.templates.springapiserverasync.order.controller;

import com.templates.springapiserverasync.order.dto.Order;
import com.templates.springapiserverasync.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{id}")
    ResponseEntity<Order> getOrder(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    ResponseEntity<List<Order>> getOrders(@RequestParam String userId) {
        return ResponseEntity.ok(orderService.getOrders(userId));
    }

    @PostMapping("/order")
    ResponseEntity<Integer> insertOrder(@RequestParam Order order) {
        return ResponseEntity.ok(orderService.insertOrder(order));
    }

    @PutMapping("/order/{id}")
    ResponseEntity<Order> updateOrder(@PathVariable String id, Order order) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    @DeleteMapping("/order{id}")
    ResponseEntity<Integer> deleteOrder(@PathVariable String id) {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
}

package com.templates.springapiserverasync.order.controller;

import com.templates.springapiserverasync.order.dto.Order;
import com.templates.springapiserverasync.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    OrderService orderService;

    @GetMapping("/order/{id}")
    ResponseEntity<Order> getOrder(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    ResponseEntity<String> getOrders() {

        return ResponseEntity.ok("");
    }

    @PostMapping("/order")
    ResponseEntity<String> insertOrder() {

        return ResponseEntity.ok("");
    }

    @PutMapping("/order/{id}")
    ResponseEntity<String> updateOrder(@PathVariable String id) {

        return ResponseEntity.ok("");
    }

    @DeleteMapping("/order{id}")
    ResponseEntity<String> deleteOrder(@PathVariable String id) {

        return ResponseEntity.ok("");
    }
}

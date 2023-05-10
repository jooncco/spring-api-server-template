package com.templates.springapiserverasync.order.controller;

import com.templates.springapiserverasync.order.dto.res.GetOrdersDTO;
import com.templates.springapiserverasync.order.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{id}")
    ResponseEntity<GetOrdersDTO> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    ResponseEntity<List<GetOrdersDTO>> getOrders(@RequestParam Integer memberId) {
        return ResponseEntity.ok(orderService.getOrders(memberId));
    }

    @PostMapping("/order")
    ResponseEntity<Integer> createOrder(@RequestParam GetOrdersDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @PutMapping("/order/{id}")
    ResponseEntity<Integer> updateOrder(@PathVariable Integer id, GetOrdersDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderDTO));
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<Integer> deleteOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
}

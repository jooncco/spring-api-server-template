package com.templates.springapiserver.order.controller;

import com.templates.springapiserver.order.dto.req.CreateOrderDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import com.templates.springapiserver.order.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{id}")
    ResponseEntity<GetOrderDTO> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    ResponseEntity<List<GetOrdersDTO>> getOrders(@RequestParam Integer memberId) {
        return ResponseEntity.ok(orderService.getOrders(memberId));
    }

    @PostMapping("/order")
    ResponseEntity<Integer> createOrder(@RequestBody CreateOrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @PutMapping("/order/{id}")
    ResponseEntity<Integer> updateOrder(
            @PathVariable Integer id, @RequestBody UpdateOrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderDTO));
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<Integer> deleteOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
}

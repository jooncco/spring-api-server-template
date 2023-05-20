package com.templates.springapiserver.order.controller;

import com.templates.springapiserver.order.dto.req.CreateOrderReqDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderReqDTO;
import com.templates.springapiserver.order.dto.res.CreateOrderResDTO;
import com.templates.springapiserver.order.dto.res.GetOrderResDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersResDTO;
import com.templates.springapiserver.order.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{id}")
    ResponseEntity<GetOrderResDTO> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    ResponseEntity<List<GetOrdersResDTO>> getOrders(@RequestParam Integer memberId) {
        return ResponseEntity.ok(orderService.getOrders(memberId));
    }

    @PostMapping("/order")
    ResponseEntity<CreateOrderResDTO> createOrder(
            @RequestBody CreateOrderReqDTO createOrderReqDTO) {
        int memberId = 0; // TODO: Extract memberId from session info

        int createdOrderId = orderService.createOrder(memberId, createOrderReqDTO);
        return ResponseEntity.accepted().body(CreateOrderResDTO.of(createdOrderId));
    }

    @PutMapping("/order/{id}")
    ResponseEntity<Integer> updateOrder(
            @PathVariable Integer id, @RequestBody UpdateOrderReqDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderDTO));
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<Integer> deleteOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
}

package com.templates.springapiserver.order.controller;

import com.templates.springapiserver.order.dto.req.CreateOrderReqDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderReqDTO;
import com.templates.springapiserver.order.dto.res.*;
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
    ResponseEntity<GetOrderResDTO> getOrderHandler(@PathVariable Integer id) {
        return ResponseEntity.ok(GetOrderResDTO.of(orderService.getOrder(id)));
    }

    @GetMapping("/orders")
    ResponseEntity<GetOrdersResDTO> getOrdersHandler(@RequestParam Integer memberId) {
        List<GetOrdersDTO> orders = orderService.getOrders(memberId);
        return ResponseEntity.ok(GetOrdersResDTO.of(orders));
    }

    @PostMapping("/order")
    ResponseEntity<CreateOrderResDTO> createOrderHandler(
            @RequestBody CreateOrderReqDTO createOrderReqDTO) {
        int memberId = 0; // TODO: Extract memberId from session info

        int createdOrderId = orderService.createOrder(memberId, createOrderReqDTO);
        return ResponseEntity.ok().body(CreateOrderResDTO.of(createdOrderId));
    }

    @PutMapping("/order/{id}")
    ResponseEntity<Void> updateOrderHandler(
            @PathVariable Integer id, @RequestBody UpdateOrderReqDTO updateOrderReqDTO) {
        int memberId = 0; // TODO: Extract memberId from session info

        orderService.updateOrderTypeAndAmounts(memberId, id, updateOrderReqDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<Void> deleteOrderHandler(@PathVariable Integer id) {
        int memberId = 0; // TODO: Extract memberId from session info

        orderService.cancelOrder(memberId, id);
        return ResponseEntity.noContent().build();
    }
}

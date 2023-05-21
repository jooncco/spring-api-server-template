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
    ResponseEntity<GetOrderResDTO> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    ResponseEntity<GetOrdersResDTO> getOrders(@RequestParam Integer memberId) {
        List<GetOrdersDTO> orders = orderService.getOrders(memberId);
        return ResponseEntity.ok(GetOrdersResDTO.of(orders));
    }

    @PostMapping("/order")
    ResponseEntity<CreateOrderResDTO> createOrder(
            @RequestBody CreateOrderReqDTO createOrderReqDTO) {
        int memberId = 0; // TODO: Extract memberId from session info

        int createdOrderId = orderService.createOrder(memberId, createOrderReqDTO);
        return ResponseEntity.accepted().body(CreateOrderResDTO.of(createdOrderId));
    }

    @PutMapping("/order/{id}")
    ResponseEntity<String> updateOrder(
            @PathVariable Integer id, @RequestBody UpdateOrderReqDTO updateOrderReqDTO) {
        int memberId = 0; // TODO: Extract memberId from session info

        orderService.updateOrder(memberId, id, updateOrderReqDTO);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
        // TODO: 준꼬님, delete하면 entity가 삭제되어 reponseStatus code 204로 설정하였는데,
        //  삭제가 상태 변경이 되면, 상태가 변경된 해당 entity를 반환하도록 변경하겠습니다!
        //  예를 들어 delete가 cancel을 의미할 수 있다고 생각되어서요!

        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }
}
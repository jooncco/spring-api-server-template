package com.templates.springapiserver.order.dto.mapper;

import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import com.templates.springapiserver.order.model.Order;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class OrderDTOMapper implements Function<Order, GetOrdersDTO> {

    @Override
    public GetOrdersDTO apply(Order order) {
        return GetOrdersDTO.builder()
                .memberId(order.getMemberId())
                .orderNo(order.getOrderNo())
                .type(order.getOrderTypeCode())
                .status(order.getOrderStatusCode())
                .itemsTotal(order.getItemTotalAmount())
                .deliveryFee(order.getDeliveryFeeAmount())
                .orderTotal(order.getOrderTotalAmount())
                .orderedDateTime(order.getCreatedDateTime())
                .build();
    }
}

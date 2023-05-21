package com.templates.springapiserver.order.dto.mapper;

import com.templates.springapiserver.order.dto.res.GetOrderDTO;
import com.templates.springapiserver.order.model.Order;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class GetOrderDTOMapper implements Function<Order, GetOrderDTO> {

    @Override
    public GetOrderDTO apply(Order order) {
        if (order == null) return null;
        return GetOrderDTO.builder()
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

package com.templates.springapiserver.order.dto.mapper;

import com.templates.springapiserver.order.dto.res.GetOrderResDTO;
import com.templates.springapiserver.order.model.mybatis.Order;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class GetOrderDTOMapper implements Function<Order, GetOrderResDTO> {

    @Override
    public GetOrderResDTO apply(Order order) {
        return GetOrderResDTO.builder()
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

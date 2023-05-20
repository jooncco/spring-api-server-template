package com.templates.springapiserver.order.dto.mapper;

import com.templates.springapiserver.order.dto.res.GetOrdersResDTO;
import com.templates.springapiserver.order.model.mybatis.Order;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class GetOrdersDTOMapper implements Function<Order, GetOrdersResDTO> {

    @Override
    public GetOrdersResDTO apply(Order order) {
        return GetOrdersResDTO.builder()
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

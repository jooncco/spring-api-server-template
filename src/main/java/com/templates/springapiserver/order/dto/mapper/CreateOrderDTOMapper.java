package com.templates.springapiserver.order.dto.mapper;

import com.templates.springapiserver.order.dto.req.CreateOrderDTO;
import com.templates.springapiserver.order.model.Order;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDTOMapper implements Function<CreateOrderDTO, Order> {

    @Override
    public Order apply(CreateOrderDTO createOrderDTO) {
        return Order.builder()
                .memberId(createOrderDTO.getMemberId())
                .orderNo(createOrderDTO.getOrderNo())
                .orderTypeCode(createOrderDTO.getType())
                .orderStatusCode(createOrderDTO.getStatus())
                .itemTotalAmount(createOrderDTO.getItemsTotal())
                .deliveryFeeAmount(createOrderDTO.getDeliveryFee())
                .orderTotalAmount(createOrderDTO.getOrderTotal())
                .createdBy(createOrderDTO.getCreatedBy())
                .build();
    }
}

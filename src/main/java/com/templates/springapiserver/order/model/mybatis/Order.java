package com.templates.springapiserver.order.model.mybatis;

import com.templates.springapiserver.constant.OrderStatus;
import com.templates.springapiserver.model.BaseModel;
import com.templates.springapiserver.order.dto.req.CreateOrderReqDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public final class Order extends BaseModel {
    private Integer orderId;
    private Integer memberId;
    @Setter private Integer orderNo;
    private String orderTypeCode;
    private String orderStatusCode;
    private Integer itemTotalAmount;
    private Integer deliveryFeeAmount;
    private Integer orderTotalAmount;

    @Builder
    public Order(
            Integer orderId,
            Integer memberId,
            Integer orderNo,
            String orderTypeCode,
            String orderStatusCode,
            Integer itemTotalAmount,
            Integer deliveryFeeAmount,
            Integer orderTotalAmount) {
        initModel(memberId);
        this.orderId = orderId;
        this.memberId = memberId;
        this.orderNo = orderNo;
        this.orderTypeCode = orderTypeCode;
        this.orderStatusCode = orderStatusCode;
        this.itemTotalAmount = itemTotalAmount;
        this.deliveryFeeAmount = deliveryFeeAmount;
        this.orderTotalAmount = orderTotalAmount;
    }

    public static Order from(Integer memberId, CreateOrderReqDTO createOrderReqDTO) {
        return Order.builder()
                .memberId(memberId)
                .orderTypeCode(createOrderReqDTO.getType().getCode())
                .orderStatusCode(OrderStatus.CREATED.getCode())
                .itemTotalAmount(createOrderReqDTO.getItemsTotal())
                .deliveryFeeAmount(createOrderReqDTO.getDeliveryFee())
                .orderTotalAmount(createOrderReqDTO.getOrderTotal())
                .build();
    }
}

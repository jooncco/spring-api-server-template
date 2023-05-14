package com.templates.springapiserver.order.model;

import com.templates.springapiserver.model.BaseModel;
import com.templates.springapiserver.order.dto.req.UpdateOrderDTO;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Order extends BaseModel {
    private Integer orderId;
    private Integer memberId;
    private Integer orderNo;
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
            Integer orderTotalAmount,
            Integer createdBy) {
        super(createdBy, createdBy);

        this.orderId = orderId;
        this.memberId = memberId;
        this.orderNo = orderNo;
        this.orderTypeCode = orderTypeCode;
        this.orderStatusCode = orderStatusCode;
        this.itemTotalAmount = itemTotalAmount;
        this.deliveryFeeAmount = deliveryFeeAmount;
        this.orderTotalAmount = orderTotalAmount;
    }

    // TODO: add update entity logic
    public void update(UpdateOrderDTO updateOrderDto) {
        this.memberId = updateOrderDto.getMemberId();
        this.orderNo = updateOrderDto.getMemberId();
        this.orderStatusCode = updateOrderDto.getStatus();
        this.itemTotalAmount = updateOrderDto.getItemsTotal();
        this.deliveryFeeAmount = updateOrderDto.getDeliveryFee();
        this.orderTotalAmount = updateOrderDto.getOrderTotal();
        this.setUpdatedBy(updateOrderDto.getUpdatedBy());
        this.setUpdatedDateTime(LocalDateTime.now());
    }
}

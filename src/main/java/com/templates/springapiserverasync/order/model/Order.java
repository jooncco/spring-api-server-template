package com.templates.springapiserverasync.order.model;

import com.templates.springapiserverasync.model.BaseModel;
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
}

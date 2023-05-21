package com.templates.springapiserver.order.dto.req;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UpdateOrderReqDTO {
    private String type;
    private String status;
    private int itemsTotal;
    private int deliveryFee;
    private int orderTotal;
    private Integer updatedBy;
}

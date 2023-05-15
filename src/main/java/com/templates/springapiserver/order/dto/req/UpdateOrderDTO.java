package com.templates.springapiserver.order.dto.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UpdateOrderDTO {
    private int memberId;
    private int orderNo;
    private String type;
    private String status;
    private int itemsTotal;
    private int deliveryFee;
    private int orderTotal;
    private Integer updatedBy;
}

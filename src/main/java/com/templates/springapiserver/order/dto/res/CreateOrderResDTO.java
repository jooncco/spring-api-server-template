package com.templates.springapiserver.order.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrderResDTO {
    private Integer orderId;

    public static CreateOrderResDTO of(int orderId) {
        return CreateOrderResDTO.builder().orderId(orderId).build();
    }
}

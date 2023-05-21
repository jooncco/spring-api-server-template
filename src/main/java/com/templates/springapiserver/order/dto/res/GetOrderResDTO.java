package com.templates.springapiserver.order.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetOrderResDTO {
    private GetOrderDTO order;

    public static GetOrderResDTO of(GetOrderDTO order) {
        return GetOrderResDTO.builder().order(order).build();
    }
}

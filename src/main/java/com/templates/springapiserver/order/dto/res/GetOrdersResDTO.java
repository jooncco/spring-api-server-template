package com.templates.springapiserver.order.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetOrdersResDTO {
    private List<GetOrdersDTO> orders;

    public static GetOrdersResDTO of(List<GetOrdersDTO> orders) {
        return GetOrdersResDTO.builder().orders(orders).build();
    }
}

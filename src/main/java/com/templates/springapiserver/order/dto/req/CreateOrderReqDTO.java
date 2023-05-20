package com.templates.springapiserver.order.dto.req;

import com.templates.springapiserver.order.constant.OrderType;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateOrderReqDTO {
    private OrderType type;
    private List<Item> items;
    private Integer itemsTotal;
    private Integer deliveryFee;
    private Integer orderTotal;

    @Getter
    @ToString
    private static class Item {
        private Integer itemId;
        private Integer quantity;
    }
}

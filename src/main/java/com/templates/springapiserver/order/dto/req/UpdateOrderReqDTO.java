package com.templates.springapiserver.order.dto.req;

import com.templates.springapiserver.order.constant.OrderType;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UpdateOrderReqDTO {
    private OrderType type;
    private List<Item> items;
    private int itemsTotal;
    private int deliveryFee;
    private int orderTotal;

    @Getter
    @ToString
    private static class Item {
        private Integer itemId;
        private Integer quantity;
    }
}

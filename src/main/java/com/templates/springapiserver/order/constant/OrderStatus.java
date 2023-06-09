package com.templates.springapiserver.order.constant;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    CREATED("CREATED", "Initial state."),
    PAID("PAID", "The user payed for order."),
    HOLDING("HOLDING", "The order is blocked for some reason."),
    CANCELED("CANCELED", "The order is canceled."),
    DELIVERY("DELIVERY", "The order is being delivered."),
    SERVED("SERVED", "The order is complete, and served successfully.");

    private final String code;
    private final String description;

    public static boolean isCancelable(String orderStatus) {
        return List.of(CREATED, HOLDING, PAID).contains(OrderStatus.valueOf(orderStatus));
    }
}

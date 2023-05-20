package com.templates.springapiserver.order.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderType {
    HERE("HERE", "For here."),
    TOGO("TOGO", "For togo.");

    private final String code;
    private final String description;
}

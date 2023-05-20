package com.templates.springapiserver.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BaseStatus {
    OK(200, "OK", "OK"),
    INVALID_REQUIRED_HEADER(401, "INVALID_REQUEST_HEADERS", "Invalid request headers"),
    UNKNOWN_ERROR(500, "UNKNOWN_ERROR", "Unknown error");

    private final Integer status;
    private final String code;
    private final String message;
}

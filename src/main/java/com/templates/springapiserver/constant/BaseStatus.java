package com.templates.springapiserver.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BaseStatus {
    OK(200, "OK", "OK"),
    BAD_REQUEST(400, "BAD_REQUEST", "Bad request"),
    INVALID_REQUEST_PARAMETER(400, "INVALID_REQUEST_PARAMETER", "Invalid request parameter"),
    UNAUTHORIZED(401, "UNAUTHORIZED", "Unauthorized"),
    FORBIDDEN(403, "FORBIDDEN", "Forbidden"),
    NOT_ACCEPTABLE(406, "NOT_ACCEPTABLE", "Not Acceptable"),
    INVALID_REQUEST_HEADER(412, "INVALID_REQUEST_HEADER", "Invalid request header"),
    UNKNOWN_ERROR(500, "UNKNOWN_ERROR", "Unknown error");

    private final Integer status;
    private final String code;
    private final String message;
}

package com.templates.springapiserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

@Builder
public class ErrorResponse {
    private String error;
    private String msg;

    @JsonInclude(Include.NON_NULL)
    private String uri;
}

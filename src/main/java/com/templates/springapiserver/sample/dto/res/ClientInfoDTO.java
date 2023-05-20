package com.templates.springapiserver.sample.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ClientInfoDTO {
    private String clientIP;
}

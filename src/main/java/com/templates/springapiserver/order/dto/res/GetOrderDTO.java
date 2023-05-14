package com.templates.springapiserver.order.dto.res;

import static com.templates.springapiserver.constant.CommonConstants.RESPONSE_DATE_TIME_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetOrderDTO {
    private int memberId;
    private int orderNo;
    private String type;
    private String status;
    private int itemsTotal;
    private int deliveryFee;
    private int orderTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = RESPONSE_DATE_TIME_FORMAT)
    private LocalDateTime orderedDateTime;
}

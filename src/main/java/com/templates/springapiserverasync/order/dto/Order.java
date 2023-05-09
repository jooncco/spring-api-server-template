package com.templates.springapiserverasync.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Order {
    private Long orderNo;
    private Long memberNo;
    private String orderStatus;
    private int orderTotal;
    private int deliveryFee;
    private Date crtDate;
}

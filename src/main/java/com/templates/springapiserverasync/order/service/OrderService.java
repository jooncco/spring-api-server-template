package com.templates.springapiserverasync.order.service;

import com.templates.springapiserverasync.order.dto.res.GetOrdersDTO;
import java.util.List;

public interface OrderService {
    GetOrdersDTO getOrder(Integer orderId);

    List<GetOrdersDTO> getOrders(Integer memberId);

    int createOrder(GetOrdersDTO orderDTO);

    int updateOrder(Integer orderId, GetOrdersDTO orderDTO);

    int deleteOrder(Integer orderId);
}

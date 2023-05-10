package com.templates.springapiserver.order.service;

import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import java.util.List;

public interface OrderService {
    GetOrdersDTO getOrder(Integer orderId);

    List<GetOrdersDTO> getOrders(Integer memberId);

    int createOrder(GetOrdersDTO orderDTO);

    int updateOrder(Integer orderId, GetOrdersDTO orderDTO);

    int deleteOrder(Integer orderId);
}

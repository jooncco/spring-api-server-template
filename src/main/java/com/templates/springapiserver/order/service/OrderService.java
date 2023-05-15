package com.templates.springapiserver.order.service;

import com.templates.springapiserver.order.dto.req.CreateOrderDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import java.util.List;

public interface OrderService {
    GetOrderDTO getOrder(Integer orderId);

    List<GetOrdersDTO> getOrders(Integer memberId);

    int createOrder(CreateOrderDTO createOrderDTO);

    int updateOrder(Integer orderId, UpdateOrderDTO orderDTO);

    int deleteOrder(Integer orderId);
}

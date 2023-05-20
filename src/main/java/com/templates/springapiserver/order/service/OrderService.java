package com.templates.springapiserver.order.service;

import com.templates.springapiserver.order.dto.req.CreateOrderReqDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderReqDTO;
import com.templates.springapiserver.order.dto.res.GetOrderResDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersResDTO;
import java.util.List;

public interface OrderService {
    GetOrderResDTO getOrder(Integer orderId);

    List<GetOrdersResDTO> getOrders(Integer memberId);

    int createOrder(int memberId, CreateOrderReqDTO createOrderReqDTO);

    int updateOrder(Integer orderId, UpdateOrderReqDTO orderDTO);

    int deleteOrder(Integer orderId);
}

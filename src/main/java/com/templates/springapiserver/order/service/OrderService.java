package com.templates.springapiserver.order.service;

import com.templates.springapiserver.exception.BaseException;
import com.templates.springapiserver.order.dto.req.CreateOrderReqDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderReqDTO;
import com.templates.springapiserver.order.dto.res.GetOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import java.util.List;

public interface OrderService {
    GetOrderDTO getOrder(Integer orderId);

    List<GetOrdersDTO> getOrders(Integer memberId);

    int createOrder(int memberId, CreateOrderReqDTO createOrderReqDTO);

    void updateOrderTypeAndAmounts(int memberId, Integer orderId, UpdateOrderReqDTO orderDTO)
            throws BaseException;

    void cancelOrder(int memberId, Integer orderId) throws BaseException;
}

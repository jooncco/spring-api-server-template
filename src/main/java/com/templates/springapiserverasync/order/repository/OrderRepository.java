package com.templates.springapiserverasync.order.repository;

import com.templates.springapiserverasync.order.dto.res.GetOrdersDTO;
import com.templates.springapiserverasync.order.model.Order;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {
    Order getOrder(Integer orderId);

    List<Order> getOrders(Integer memberId);

    // TODO: define CreateOrderReqDTO and use it here.
    int insertOrder(GetOrdersDTO orderDTO);

    // TODO: define UpdateOrderReqDTO and use it here.
    int updateOrder(Integer orderId, GetOrdersDTO orderDTO);

    int deleteOrder(Integer orderId);
}

package com.templates.springapiserver.order.repository.mybatis;

import com.templates.springapiserver.order.model.mybatis.Order;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {
    Optional<Order> getOrder(Integer orderId);

    List<Order> getOrders(Integer memberId);

    // TODO: define CreateOrderReqDTO and use it here.
    int insertOrder(Order order);

    // TODO: define UpdateOrderReqDTO and use it here.
    int updateOrder(Order Order);

    int deleteOrder(Integer orderId);
}

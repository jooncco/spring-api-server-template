package com.templates.springapiserver.order.repository;

import com.templates.springapiserver.order.constant.OrderStatus;
import com.templates.springapiserver.order.model.Order;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {
    Optional<Order> getOrder(Integer orderId);

    List<Order> getOrders(Integer memberId);

    int insertOrder(Order order);

    int updateOrderTypeAndAmounts(
            Integer orderId,
            String orderTypeCode,
            Integer itemTotalAmount,
            Integer deliveryFeeAmount,
            Integer orderTotalAmount,
            Integer updatedBy,
            LocalDateTime updatedDateTime);

    int updateOrderStatus(
            Integer orderId,
            OrderStatus orderStatusCode,
            Integer updatedBy,
            LocalDateTime updatedDateTime);
}

package com.templates.springapiserver.order.service;

import com.templates.springapiserver.order.dto.mapper.OrderDTOMapper;
import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import com.templates.springapiserver.order.model.Order;
import com.templates.springapiserver.order.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderDTOMapper orderDTOMapper;

    @Override
    public GetOrdersDTO getOrder(Integer orderId) {

        // TODO: implement get order api.
        return null;
    }

    @Override
    public List<GetOrdersDTO> getOrders(Integer memberId) {
        List<Order> orders = orderRepository.getOrders(memberId);
        return orders.stream().map(orderDTOMapper).toList();
    }

    @Override
    public int createOrder(GetOrdersDTO orderDTO) {
        // TODO: implement createOrder service.
        // 가게 오픈시마다 초기화되는 주문번호 채번 로직을 구성해보면 좋겠죠?
        return orderRepository.insertOrder(orderDTO);
    }

    // TODO: define updateOrderDTO and use it here.
    @Override
    public int updateOrder(Integer orderId, GetOrdersDTO orderDTO) {
        // TODO: implement update order api.
        return 0;
    }

    @Override
    public int deleteOrder(Integer orderId) {
        // TODO: implement delete order api.
        return orderRepository.deleteOrder(orderId);
    }
}

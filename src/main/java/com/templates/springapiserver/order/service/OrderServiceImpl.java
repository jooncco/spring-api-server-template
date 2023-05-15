package com.templates.springapiserver.order.service;

import com.templates.springapiserver.order.dto.mapper.CreateOrderDTOMapper;
import com.templates.springapiserver.order.dto.mapper.GetOrderDTOMapper;
import com.templates.springapiserver.order.dto.mapper.GetOrdersDTOMapper;
import com.templates.springapiserver.order.dto.req.CreateOrderDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import com.templates.springapiserver.order.model.Order;
import com.templates.springapiserver.order.repository.OrderRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final GetOrdersDTOMapper getOrdersDTOMapper;
    private final GetOrderDTOMapper getOrderDTOMapper;
    private final CreateOrderDTOMapper createOrderDTOMapper;

    @Override
    public GetOrderDTO getOrder(Integer orderId) {
        return getOrderDTOMapper.apply(
                orderRepository.getOrder(orderId).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public List<GetOrdersDTO> getOrders(Integer memberId) {
        List<Order> orders = orderRepository.getOrders(memberId);
        return orders.stream().map(getOrdersDTOMapper).toList();
    }

    @Override
    public int createOrder(CreateOrderDTO createOrderDTO) {
        // TODO: implement createOrder service.
        // 가게 오픈시마다 초기화되는 주문번호 채번 로직을 구성해보면 좋겠죠?
        return orderRepository.insertOrder(createOrderDTOMapper.apply(createOrderDTO));
    }

    @Override
    public int updateOrder(Integer orderId, UpdateOrderDTO updateOrderDTO) {
        Order order = orderRepository.getOrder(orderId).orElseThrow(NoSuchElementException::new);
        order.update(updateOrderDTO);

        orderRepository.updateOrder(order);
        // TODO: insert, update, delete 의 response는 어떻게 할것인가?
        return 0;
    }

    @Override
    public int deleteOrder(Integer orderId) {
        return orderRepository.deleteOrder(orderId);
    }
}

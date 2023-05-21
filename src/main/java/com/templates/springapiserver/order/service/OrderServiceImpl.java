package com.templates.springapiserver.order.service;

import com.templates.springapiserver.order.dto.mapper.GetOrderDTOMapper;
import com.templates.springapiserver.order.dto.mapper.GetOrdersDTOMapper;
import com.templates.springapiserver.order.dto.req.CreateOrderReqDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderReqDTO;
import com.templates.springapiserver.order.dto.res.GetOrderResDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import com.templates.springapiserver.order.model.mybatis.Order;
import com.templates.springapiserver.order.repository.mybatis.OrderRepository;
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

    @Override
    public GetOrderResDTO getOrder(Integer orderId) {
        return getOrderDTOMapper.apply(
                orderRepository.getOrder(orderId).orElseThrow(NoSuchElementException::new));
    }

    /**
     * Get list of orders placed by given memberId.
     *
     * @param memberId
     * @return list of orders
     */
    @Override
    public List<GetOrdersDTO> getOrders(Integer memberId) {
        List<Order> orders = orderRepository.getOrders(memberId);
        return orders.stream().map(getOrdersDTOMapper).toList();
    }

    /**
     * Creates single order entity
     *
     * @param createOrderReqDTO
     * @return orderId
     */
    @Override
    public int createOrder(int memberId, CreateOrderReqDTO createOrderReqDTO) {

        Order order = Order.from(memberId, createOrderReqDTO);

        int orderNo = 0; // TODO: 가게 오픈시마다 초기화되는 주문번호 채번 로직. OrderNoUtility 내부에 구현
        order.setOrderNo(orderNo);

        orderRepository.insertOrder(order);
        return order.getOrderId();
    }

    /**
     * update single order entity
     *
     * @param memberId
     * @param orderId
     * @param updateOrderReqDTO
     * @return 1 - success(updated order count), 0 - fail
     */
    @Override
    public int updateOrder(int memberId, Integer orderId, UpdateOrderReqDTO updateOrderReqDTO) {
        Order order = Order.update(memberId, orderId, updateOrderReqDTO);

        return orderRepository.updateOrder(order);
    }

    /**
     * delete single order entity
     *
     * @param orderId
     * @return 1 - success(deleted row count), 0 - fail
     */
    @Override
    public int deleteOrder(Integer orderId) {
        return orderRepository.deleteOrder(orderId);
    }
}

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

    @Override
    public int updateOrder(Integer orderId, UpdateOrderReqDTO updateOrderReqDTO) {
        // TODO: to 조던님
        // order 데이터를 조회해서 업데이트하는 방식을 DB 커넥션을 두번 만들게 되니, orderId 를 where 절에 넣어서
        // 해당 rows 를 바로 업데이트 하도록 해서 DB 커넥션 한번으로 하면 더 좋을것 같아요.
        // UpdateOrderReqDTO 에도 변경 대상만 담도록 API 를 설계해 보세요 ㅎㅎ
        //        Order order =
        // orderRepository.getOrder(orderId).orElseThrow(NoSuchElementException::new);
        //        orderRepository.updateOrder(order);
        return 0;
    }

    @Override
    public int deleteOrder(Integer orderId) {
        // TODO: delete
        return orderRepository.deleteOrder(orderId);
    }
}

package com.templates.springapiserver.order.service;

import static com.templates.springapiserver.constant.CommonConstants.DEFAULT_SERVER_ZONE_OFFSET;

import com.templates.springapiserver.constant.BaseStatus;
import com.templates.springapiserver.exception.BaseException;
import com.templates.springapiserver.order.constant.OrderStatus;
import com.templates.springapiserver.order.dto.mapper.GetOrderDTOMapper;
import com.templates.springapiserver.order.dto.mapper.GetOrdersDTOMapper;
import com.templates.springapiserver.order.dto.req.CreateOrderReqDTO;
import com.templates.springapiserver.order.dto.req.UpdateOrderReqDTO;
import com.templates.springapiserver.order.dto.res.GetOrderDTO;
import com.templates.springapiserver.order.dto.res.GetOrdersDTO;
import com.templates.springapiserver.order.model.Order;
import com.templates.springapiserver.order.repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** OrderService implementation */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final GetOrdersDTOMapper getOrdersDTOMapper;
    private final GetOrderDTOMapper getOrderDTOMapper;

    /**
     * Get order specified by given orderId.
     *
     * @param orderId
     * @return order details
     */
    @Override
    public GetOrderDTO getOrder(Integer orderId) {
        return getOrderDTOMapper.apply(orderRepository.getOrder(orderId).orElse(null));
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

        // Insert into ORDER_ITEM table. (Omitted. This is just a template.)

        Order order = Order.from(memberId, createOrderReqDTO);
        // Generate orderNo. (Omitted. This is just a template.)
        int orderNo = 0;
        order.setOrderNo(orderNo);

        orderRepository.insertOrder(order);
        return order.getOrderId();
    }

    /**
     * Update single order entity. It updates order type and amounts.
     *
     * @param memberId
     * @param orderId
     * @param updateOrderReqDTO
     * @return orderId if success
     * @throws BaseException
     */
    @Override
    public void updateOrderTypeAndAmounts(
            int memberId, Integer orderId, UpdateOrderReqDTO updateOrderReqDTO)
            throws BaseException {

        // Update ORDER_ITEM table. (Omitted. This is just a template.)

        int updatedRows =
                orderRepository.updateOrderTypeAndAmounts(
                        orderId,
                        updateOrderReqDTO.getType().getCode(),
                        updateOrderReqDTO.getItemsTotal(),
                        updateOrderReqDTO.getDeliveryFee(),
                        updateOrderReqDTO.getOrderTotal(),
                        memberId,
                        LocalDateTime.now(DEFAULT_SERVER_ZONE_OFFSET));
        if (updatedRows == 0) {
            throw BaseException.of(BaseStatus.BAD_REQUEST, "No such order with given orderId.");
        }
        if (updatedRows != 1) {
            throw BaseException.of(BaseStatus.UNKNOWN_ERROR);
        }
    }

    /**
     * Cancel single order entity
     *
     * @param memberId
     * @param orderId
     * @throws BaseException
     */
    @Override
    public void cancelOrder(int memberId, Integer orderId) throws BaseException {
        Order targetOrder =
                orderRepository
                        .getOrder(orderId)
                        .orElseThrow(
                                () ->
                                        BaseException.of(
                                                BaseStatus.BAD_REQUEST,
                                                "No such order with given orderId."));

        // Check if order is in cancelable state.
        if (!OrderStatus.isCancelable(targetOrder.getOrderStatusCode())) {
            throw BaseException.of(
                    BaseStatus.NOT_ACCEPTABLE,
                    String.format(
                            "This order can not be canceled. Status: %s",
                            targetOrder.getOrderStatusCode()));
        }

        int updatedRows =
                orderRepository.updateOrderStatus(
                        orderId, OrderStatus.CANCELED, memberId, LocalDateTime.now());
        if (updatedRows != 1) {
            throw BaseException.of(BaseStatus.UNKNOWN_ERROR);
        }
    }
}

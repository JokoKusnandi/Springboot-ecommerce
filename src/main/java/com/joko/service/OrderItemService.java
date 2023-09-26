package com.joko.service;

import java.util.List;

import com.joko.dao.OrderItem;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(Long orderItemId);

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(Long orderItemId, OrderItem orderItem);

    void deleteOrderItem(Long orderItemId);
}

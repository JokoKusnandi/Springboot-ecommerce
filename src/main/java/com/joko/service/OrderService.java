package com.joko.service;

import java.util.List;

import com.joko.dao.Order;

public interface OrderService {

	List<Order> getAllOrders();

	Order getOrderById(Long orderId);

	Order createOrder(Order order);

	Order updateOrder(Long orderId, Order updatedOrder);

	boolean deleteOrder(Long orderId);

}

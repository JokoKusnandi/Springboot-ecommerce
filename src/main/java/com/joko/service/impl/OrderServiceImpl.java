package com.joko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joko.dao.Order;
import com.joko.repository.OrderRepository;
import com.joko.service.OrderService;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        // You can add validation and business logic here
    	order.setOrderDate(LocalDate.now());
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order existingOrder = getOrderById(orderId);
        if (existingOrder != null) {
            // Update the fields you want to allow modification
            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setStatus(updatedOrder.getStatus());
            // Add more fields as needed

            // Save the updated order
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        Order existingOrder = getOrderById(orderId);
        if (existingOrder != null) {
            orderRepository.delete(existingOrder);
            return true;
        } else {
            return false;
        }
    }
}


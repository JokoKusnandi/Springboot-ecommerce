package com.joko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joko.dao.OrderItem;
import com.joko.exception.OrderItemNotFoundException;
import com.joko.repository.OrderItemRepository;
import com.joko.service.OrderItemService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new OrderItemNotFoundException(orderItemId));
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Long orderItemId, OrderItem orderItem) {
        if (!orderItemRepository.existsById(orderItemId)) {
            throw new OrderItemNotFoundException(orderItemId);
        }
        orderItem.setOrderItemId(orderItemId);
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        if (!orderItemRepository.existsById(orderItemId)) {
            throw new OrderItemNotFoundException(orderItemId);
        }
        orderItemRepository.deleteById(orderItemId);
    }
}


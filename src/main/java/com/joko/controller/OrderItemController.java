package com.joko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.joko.dao.OrderItem;
import com.joko.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable Long orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @PostMapping("/")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @PutMapping("/{orderItemId}")
    public OrderItem updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(orderItemId, orderItem);
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}


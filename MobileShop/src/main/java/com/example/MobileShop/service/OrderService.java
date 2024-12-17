package com.example.MobileShop.service;

import com.example.MobileShop.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(Order order);
    Optional<Order> getOrderById(String id);
    List<Order> getAllOrders();
    void deleteOrder(String id);
}

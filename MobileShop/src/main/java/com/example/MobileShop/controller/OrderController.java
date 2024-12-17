package com.example.MobileShop.controller;

import com.example.MobileShop.model.Order;
import com.example.MobileShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully with ID: " + id;
    }
}

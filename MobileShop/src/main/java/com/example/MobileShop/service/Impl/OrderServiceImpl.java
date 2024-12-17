package com.example.MobileShop.service.Impl;

import com.example.MobileShop.model.Order;
import com.example.MobileShop.model.product;
import com.example.MobileShop.repository.OrderRepository;
import com.example.MobileShop.repository.ProductRepository;
import com.example.MobileShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Order placeOrder(Order order) {
        // Ensure all products in the order are in stock
        for (String productId : order.getProductIds()) {
            product products = productRepository.findById(productId).orElseThrow();
            if (!products.isInStock()) {
                throw new RuntimeException("Product out of stock: " + products.getName());
            }

            // Reduce stock of the product
            products.setInStock(false);
            productRepository.save(products);
        }

        order.setStatus("PLACED");
        return orderRepository.save(order); 
                                            // need to write the code to send order details to the admin and customer that order has placed
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll(); 
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id); 
    }
}

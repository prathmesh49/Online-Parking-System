package com.example.service;

import com.example.model.Orders;
import com.example.repository.OrdersRepository;
import com.example.serviceInterfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrdersRepository orderRepository;

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public void placeOrder(Orders order) {
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}

package com.example.serviceInterfaces;

import com.example.model.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAllOrders();
    Orders getOrderById(int orderId);
    void placeOrder(Orders order);
    void cancelOrder(int orderId);
}

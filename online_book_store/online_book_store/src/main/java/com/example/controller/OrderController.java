package com.example.controller;

import com.example.model.Orders;
import com.example.serviceInterfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public void placeOrder(@RequestBody Orders order) {
        orderService.placeOrder(order);
    }

    @GetMapping("/{orderId}")
    public Orders getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("/cancel/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Integer orderId){
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("order Canceled");
    }
}

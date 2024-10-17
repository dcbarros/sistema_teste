package com.api.teste.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.teste.demo.model.Order;
import com.api.teste.demo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrderByStatus(String status){
        return orderRepository.findOrdersByStatus(status);
    }

    public void updateStatus(Integer order_id, String new_status){
        Order order = orderRepository.findById(order_id)
        .orElseThrow(() -> new RuntimeException("Order not found with id: " + order_id));
    
        if(!order.getStatus().equals(new_status)){
            order.setStatus(new_status);
            orderRepository.save(order);
        }
    }
}

package com.api.teste.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.teste.demo.model.Order;
import com.api.teste.demo.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/search")
    public List<Order> getOrdersByStatus(@RequestParam(name = "status", required = false, defaultValue = "pending") String status) {
        return orderService.getOrderByStatus(status);
    }
    
    @PatchMapping("/{id}/status")
    public void changeOrderStatus(@RequestParam(name = "status") String status, @PathVariable Integer id){
        orderService.updateStatus(id, status);
    }
}

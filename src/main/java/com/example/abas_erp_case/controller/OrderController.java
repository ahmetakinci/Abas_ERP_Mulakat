package com.example.abas_erp_case.controller;

import com.example.abas_erp_case.entity.OrderEntity;
import com.example.abas_erp_case.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody OrderEntity orderEntity) {
        orderService.saveOrder(orderEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order saved successfully.");
    }

    @GetMapping("/totalAmount")
    public double getTotalAmount() {
        return orderService.getTotalAmount();
    }

    @GetMapping("/averagePrice")
    public double getAveragePrice() {
        return orderService.getAveragePrice();
    }

    @GetMapping("/itemAveragePrices")
    public Map<Integer, Double> getItemAveragePrices() {
        return orderService.getItemAveragePrices();
    }

    @GetMapping("/itemOrderQuantities")
    public Map<Integer, Map<Integer, Integer>> getItemOrderQuantities() {
        return orderService.getItemOrderQuantities();
    }
}

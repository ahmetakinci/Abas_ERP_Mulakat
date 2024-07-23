package com.example.abas_erp_case.service;

import com.example.abas_erp_case.entity.OrderEntity;
import com.example.abas_erp_case.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {


    private final OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public void saveOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    public double getTotalAmount() {
        return orderRepository.findAll().stream()
                .mapToDouble(orderEntity -> orderEntity.getQuantity() * orderEntity.getUnitPrice())
                .sum();
    }

    public double getAveragePrice() {
        return orderRepository.findAll().stream()
                .mapToDouble(OrderEntity::getUnitPrice)
                .average()
                .orElse(0.0);
    }

    public Map<Integer, Double> getItemAveragePrices() {
        return orderRepository.findAll().stream()
                .collect(Collectors.groupingBy(OrderEntity::getItemId,
                        Collectors.averagingDouble(OrderEntity::getUnitPrice)));
    }

    public Map<Integer, Map<Integer, Integer>> getItemOrderQuantities() {
        return orderRepository.findAll().stream()
                .collect(Collectors.groupingBy(OrderEntity::getItemId,
                        Collectors.groupingBy(OrderEntity::getOrderId,
                                Collectors.summingInt(OrderEntity::getQuantity))));
    }
}

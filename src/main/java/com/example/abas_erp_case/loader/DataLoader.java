package com.example.abas_erp_case.loader;

import com.example.abas_erp_case.entity.OrderEntity;
import com.example.abas_erp_case.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataLoader {

    @Autowired
    private OrderRepository orderRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            orderRepository.save(new OrderEntity(1L, 1000, 2000, 12, 100.51));
            orderRepository.save(new OrderEntity(2L, 1000, 2001, 31, 200.00));
            orderRepository.save(new OrderEntity(3L, 1000, 2002, 22, 150.86));
            orderRepository.save(new OrderEntity(4L, 1000, 2003, 41, 250.00));
            orderRepository.save(new OrderEntity(5L, 1000, 2004, 55, 244.00));

            orderRepository.save(new OrderEntity(6L, 1001, 2001, 88, 44.53));
            orderRepository.save(new OrderEntity(7L, 1001, 2002, 121, 88.11));
            orderRepository.save(new OrderEntity(8L, 1001, 2004, 74, 211.00));
            orderRepository.save(new OrderEntity(9L, 1001, 2002, 14, 88.11));

            orderRepository.save(new OrderEntity(10L, 1002, 2003, 2, 12.10));
            orderRepository.save(new OrderEntity(11L, 1002, 2004, 3, 22.30));
            orderRepository.save(new OrderEntity(12L, 1002, 2003, 8, 12.10));
            orderRepository.save(new OrderEntity(13L, 1002, 2002, 16, 94.00));
            orderRepository.save(new OrderEntity(14L, 1002, 2005, 9, 44.10));
            orderRepository.save(new OrderEntity(15L, 1002, 2006, 19, 90.00));
        };
    }
}

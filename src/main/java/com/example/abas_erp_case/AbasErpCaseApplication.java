package com.example.abas_erp_case;

import com.example.abas_erp_case.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AbasErpCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbasErpCaseApplication.class, args);
    }

    @Bean
    CommandLineRunner run(OrderService orderService) {
        return args -> {

            System.out.println("Total Amount: " + orderService.getTotalAmount());
            System.out.println("Average Price: " + orderService.getAveragePrice());
            System.out.println("Item Average Prices: " + orderService.getItemAveragePrices());
            System.out.println("Item Order Quantities: " + orderService.getItemOrderQuantities());
        };
    }
}

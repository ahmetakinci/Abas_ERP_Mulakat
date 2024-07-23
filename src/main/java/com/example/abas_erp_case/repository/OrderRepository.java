package com.example.abas_erp_case.repository;

import com.example.abas_erp_case.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}

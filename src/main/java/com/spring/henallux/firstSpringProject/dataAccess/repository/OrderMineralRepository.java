package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMineralRepository extends JpaRepository<OrderMineralEntity, Integer> {
}

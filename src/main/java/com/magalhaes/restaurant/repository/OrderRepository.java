package com.magalhaes.restaurant.repository;

import com.magalhaes.restaurant.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

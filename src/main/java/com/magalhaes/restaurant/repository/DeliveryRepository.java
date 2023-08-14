package com.magalhaes.restaurant.repository;

import com.magalhaes.restaurant.dao.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}

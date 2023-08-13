package com.magalhaes.crud.repository;

import com.magalhaes.crud.dao.DeliveryDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryDAO, Long> {
}

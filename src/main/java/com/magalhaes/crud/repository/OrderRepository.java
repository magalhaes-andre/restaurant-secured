package com.magalhaes.crud.repository;

import com.magalhaes.crud.dao.OrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDAO, Long> {
}

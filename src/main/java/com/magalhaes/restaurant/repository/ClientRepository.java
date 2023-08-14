package com.magalhaes.restaurant.repository;

import com.magalhaes.restaurant.dao.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

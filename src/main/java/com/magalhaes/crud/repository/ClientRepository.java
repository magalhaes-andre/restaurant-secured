package com.magalhaes.crud.repository;

import com.magalhaes.crud.dao.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

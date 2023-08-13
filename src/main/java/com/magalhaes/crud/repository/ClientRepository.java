package com.magalhaes.crud.repository;

import com.magalhaes.crud.dao.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientDAO, Long> {
}

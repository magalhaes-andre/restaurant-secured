package com.magalhaes.crud.service;

import com.magalhaes.crud.dao.DeliveryDAO;
import com.magalhaes.crud.dto.DeliveryDTO;
import com.magalhaes.crud.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository repository;

    public DeliveryDAO saveDelivery(DeliveryDTO dto) {
        DeliveryDAO dao = new DeliveryDAO();
        dao.setAddress(dto.getAddress());
        dao.setStatus(dto.getStatus());
        return repository.save(dao);
    }

    public Optional<DeliveryDAO> findById(Long id) {
        return repository.findById(id);
    }
}

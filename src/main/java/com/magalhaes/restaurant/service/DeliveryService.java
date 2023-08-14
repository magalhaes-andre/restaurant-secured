package com.magalhaes.restaurant.service;

import com.magalhaes.restaurant.dao.Delivery;
import com.magalhaes.restaurant.dto.DeliveryRequest;
import com.magalhaes.restaurant.exceptions.ResourceNotFoundException;
import com.magalhaes.restaurant.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository repository;

    @Autowired
    OrderService orderService;

    public Delivery save(DeliveryRequest request) {
        Delivery delivery = new Delivery();
        delivery.setAddress(request.getAddress());
        return repository.save(delivery);
    }

    public List<Delivery> fetchAll() {
        return repository.findAll();
    }

    public Delivery findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No Delivery found with id: {}", id)));
    }

    public Delivery update(Long id, DeliveryRequest updateRequest) {
        Delivery currentDelivery = findById(id);
        currentDelivery.setAddress(updateRequest.getAddress());
        return repository.save(currentDelivery);
    }

    public void delete(Long id) {
        Delivery deliveryToDelete = findById(id);
        repository.delete(deliveryToDelete);
    }
}

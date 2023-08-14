package com.magalhaes.restaurant.controller;

import com.magalhaes.restaurant.dao.Delivery;
import com.magalhaes.restaurant.dto.DeliveryRequest;
import com.magalhaes.restaurant.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/deliveries")
public class DeliveryController {

    @Autowired
    DeliveryService service;
    @PostMapping
    public ResponseEntity<Delivery> post(DeliveryRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAll() {
        return ResponseEntity.ok(service.fetchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Delivery> update(@PathVariable Long id, DeliveryRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}

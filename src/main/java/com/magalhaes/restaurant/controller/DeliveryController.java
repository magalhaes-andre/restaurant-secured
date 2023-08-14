package com.magalhaes.restaurant.controller;

import com.magalhaes.restaurant.dao.Delivery;
import com.magalhaes.restaurant.dto.DeliveryRequest;
import com.magalhaes.restaurant.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deliveries")
public class DeliveryController {

    @Autowired
    DeliveryService service;
    @PostMapping
    public ResponseEntity<Delivery> post(DeliveryRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> fetchAll() {
        return ResponseEntity.ok(service.fetchAll());
    }

    @PutMapping
    public ResponseEntity<Delivery> update(Long id, DeliveryRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}

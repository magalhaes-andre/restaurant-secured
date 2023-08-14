package com.magalhaes.restaurant.controller;

import com.magalhaes.restaurant.dao.Order;
import com.magalhaes.restaurant.dto.OrderRequest;
import com.magalhaes.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Order> post(@Validated @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(service.save(orderRequest));
    }

    @GetMapping
    public ResponseEntity<List<Order>> fetchAll() {
        return ResponseEntity.ok(service.fetchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @Validated @RequestBody OrderRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}

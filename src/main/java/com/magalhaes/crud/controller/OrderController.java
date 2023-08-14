package com.magalhaes.crud.controller;

import com.magalhaes.crud.dao.Order;
import com.magalhaes.crud.dto.OrderDTO;
import com.magalhaes.crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService service;
    @PostMapping
    public ResponseEntity<Order> postOrder(@Validated @RequestBody OrderDTO orderDTO) {
        //TODO checkUserExistence
        //TODO createDelivery
        return ResponseEntity.ok(service.saveOrder(orderDTO).orElseThrow());
    }

    @GetMapping
    public ResponseEntity<List<Order>> fetchAllOrders() {
        return ResponseEntity.ok(service.fetchAllOrders());
    }
}

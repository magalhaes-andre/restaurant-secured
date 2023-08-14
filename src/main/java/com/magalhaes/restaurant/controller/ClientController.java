package com.magalhaes.restaurant.controller;

import com.magalhaes.restaurant.dao.Client;
import com.magalhaes.restaurant.dto.ClientRequest;
import com.magalhaes.restaurant.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<Client> post(@Validated @RequestBody ClientRequest request) {
        return ResponseEntity.ok(service.saveClient(request));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(service.fetchAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody ClientRequest request) {
        return ResponseEntity.ok(service.updateClient(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteClient(id);
        return ResponseEntity.ok(getAll());
    }
}

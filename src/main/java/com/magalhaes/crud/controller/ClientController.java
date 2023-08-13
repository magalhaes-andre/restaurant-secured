package com.magalhaes.crud.controller;

import com.magalhaes.crud.dao.ClientDAO;
import com.magalhaes.crud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientDAO> postClient(@Validated @RequestBody ClientDAO clientDAO) {
        return ResponseEntity.ok(service.saveClient(clientDAO));
    }

    @GetMapping
    public ResponseEntity<List<ClientDAO>> fetchAllClients() {
        return ResponseEntity.ok(service.fetchAllClients());
    }
}

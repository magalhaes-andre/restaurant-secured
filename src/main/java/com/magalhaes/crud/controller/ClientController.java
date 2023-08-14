package com.magalhaes.crud.controller;

import com.magalhaes.crud.dao.Client;
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
    public ResponseEntity<Client> postClient(@Validated @RequestBody Client client) {
        return ResponseEntity.ok(service.saveClient(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>> fetchAllClients() {
        return ResponseEntity.ok(service.fetchAllClients());
    }
}

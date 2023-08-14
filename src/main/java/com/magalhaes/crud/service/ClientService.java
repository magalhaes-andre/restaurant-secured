package com.magalhaes.crud.service;

import com.magalhaes.crud.dao.Client;
import com.magalhaes.crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client saveClient(Client client) {
        return repository.save(client);
    }

    public Client updateClient(Long id, Client clientUpdate) {
        Client currentClient = repository.findById(id).orElseThrow();
        clientUpdate.setId(currentClient.getId());
        return saveClient(clientUpdate);
    }
    public List<Client> fetchAllClients() {
        return repository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }
}

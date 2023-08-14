package com.magalhaes.restaurant.service;

import com.magalhaes.restaurant.dao.Client;
import com.magalhaes.restaurant.exceptions.ResourceNotFoundException;
import com.magalhaes.restaurant.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client saveClient(Client client) {
        return repository.save(client);
    }

    public List<Client> fetchAllClients() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No Client found with id:{}", id)));
    }

    public Client updateClient(Long id, Client clientUpdate) {
        Client currentClient = findById(id);
        clientUpdate.setId(currentClient.getId());
        return saveClient(clientUpdate);
    }

    public void deleteClient(Long id) {
        Client clientToDelete = findById(id);
        repository.delete(clientToDelete);
    }
}

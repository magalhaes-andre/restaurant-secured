package com.magalhaes.crud.service;

import com.magalhaes.crud.dao.ClientDAO;
import com.magalhaes.crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDAO saveClient(ClientDAO clientDAO) {
        return repository.save(clientDAO);
    }

    public ClientDAO updateClient(Long id, ClientDAO clientUpdate) {
        ClientDAO currentClient = repository.findById(id).orElseThrow();
        clientUpdate.setId(currentClient.getId());
        return repository.save(clientUpdate);
    }
    public List<ClientDAO> fetchAllClients() {
        return repository.findAll();
    }

    public Optional<ClientDAO> findById(Long id) {
        return repository.findById(id);
    }
}

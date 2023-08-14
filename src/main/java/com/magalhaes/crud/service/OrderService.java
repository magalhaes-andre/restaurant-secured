package com.magalhaes.crud.service;

import com.magalhaes.crud.dao.Client;
import com.magalhaes.crud.dao.Delivery;
import com.magalhaes.crud.dao.Order;
import com.magalhaes.crud.dto.OrderDTO;
import com.magalhaes.crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private DeliveryService deliveryService;

    @Transactional
    public Optional<Order> saveOrder(OrderDTO orderDTO) {
        Client client = clientService.findById(orderDTO.getClientId()).orElseThrow();
        Delivery delivery = deliveryService.saveDelivery(orderDTO.getDelivery());
        Order order = new Order();
        order.setDescription(orderDTO.getDescription());
        order.setDelivery(delivery);
        order.setClient(client);
        Order repositoryOrder = repository.save(order);
        client.getOrders().add(repositoryOrder);
        clientService.updateClient(client.getId(), client);
        return repository.findById(repositoryOrder.getId());
    }

    public List<Order> fetchAllOrders() {
        return repository.findAll();
    }
}

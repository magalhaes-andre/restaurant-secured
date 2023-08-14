package com.magalhaes.restaurant.service;

import com.magalhaes.restaurant.dao.Client;
import com.magalhaes.restaurant.dao.Delivery;
import com.magalhaes.restaurant.dao.Order;
import com.magalhaes.restaurant.dto.OrderRequest;
import com.magalhaes.restaurant.exceptions.ResourceNotFoundException;
import com.magalhaes.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private DeliveryService deliveryService;

    @Transactional
    public Order save(OrderRequest orderRequest) {
        Client client = clientService.findById(orderRequest.getClientId());
        Delivery delivery = deliveryService.save(orderRequest.getDelivery());
        Order order = new Order();
        order.setDescription(orderRequest.getDescription());
        order.setDelivery(delivery);
        order.setClient(client);
        Order repositoryOrder = repository.save(order);
        client.getOrders().add(repositoryOrder);
        clientService.updateClient(client.getId(), client);
        return findById(repositoryOrder.getId());
    }

    public List<Order> fetchAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No Order found for the following id:{}", id)));
    }

    public Order update(Long id, OrderRequest updateRequest) {
        Order currentOrder = findById(id);
        Delivery currentOrderDelivery = deliveryService.findById(currentOrder.getDelivery().getId());
        deliveryService.update(currentOrderDelivery.getId(), updateRequest.getDelivery());
        currentOrder.setDescription(updateRequest.getDescription());
        return repository.save(currentOrder);
    }

    public void delete(Long id) {
        Order orderToDelete = findById(id);
        repository.delete(orderToDelete);
    }
}

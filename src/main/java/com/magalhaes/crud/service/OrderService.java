package com.magalhaes.crud.service;

import com.magalhaes.crud.dao.ClientDAO;
import com.magalhaes.crud.dao.DeliveryDAO;
import com.magalhaes.crud.dao.OrderDAO;
import com.magalhaes.crud.dto.OrderDTO;
import com.magalhaes.crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private DeliveryService deliveryService;
    public OrderDAO saveOrder(OrderDTO orderDTO) {
        ClientDAO client = clientService.findById(orderDTO.getClientId()).orElseThrow();
        DeliveryDAO delivery = deliveryService.saveDelivery(orderDTO.getDelivery());
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setDescription(orderDTO.getDescription());
        orderDAO.setDelivery(delivery);
        orderDAO.setClient(client);
        client.getOrders().add(orderDAO);
        clientService.updateClient(client.getId(), client);
        return repository.save(orderDAO);
    }

    public List<OrderDAO> fetchAllOrders() {
        return repository.findAll();
    }
}

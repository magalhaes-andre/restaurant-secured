package com.magalhaes.crud.dto;

import com.magalhaes.crud.dao.DeliveryDAO;
import com.magalhaes.crud.dao.OrderDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.criterion.Order;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private String description;
    private DeliveryDTO delivery;
    private Long clientId;
}

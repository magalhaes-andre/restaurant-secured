package com.magalhaes.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {

    private String description;
    private DeliveryRequest delivery;
    private Long clientId;
}

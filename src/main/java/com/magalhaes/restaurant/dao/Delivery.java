package com.magalhaes.restaurant.dao;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    public Delivery(String address, int status) {
        this.address = address;
    }
}

package com.med.springboot.client;

import com.med.springboot.order.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String wantedProduct;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}

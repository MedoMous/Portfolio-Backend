package com.med.springboot.order;

import com.med.springboot.SE.SoftwareEngineer;
import com.med.springboot.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "order_engineers",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "engineer_id")
    )
    private List<SoftwareEngineer> team;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private String projectName;
    private String description;
    private Integer estimatedDays;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

}
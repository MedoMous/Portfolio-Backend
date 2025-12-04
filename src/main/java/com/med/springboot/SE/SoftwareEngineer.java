package com.med.springboot.SE;

import com.med.springboot.order.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "software_engineer")
@Data
public class SoftwareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String techStack;

    @ManyToMany(mappedBy = "team")
    private List<Order> orders;
}

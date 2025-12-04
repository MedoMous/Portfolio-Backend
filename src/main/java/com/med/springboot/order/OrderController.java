package com.med.springboot.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public Order createOrder(
            @RequestBody OrderRequest order){
        return service.addOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return service.findAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(
            @PathVariable Long id){
        return service.findOrderById(id);
    }
    @PutMapping("/{id}")
    public Order updateOrder(
            @PathVariable Long id, @RequestBody OrderRequest request){
        return service.updateOrder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(
            @PathVariable Long id){
        service.deleteOrder(id);
    }
}

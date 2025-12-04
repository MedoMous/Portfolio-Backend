package com.med.springboot.order;

import com.med.springboot.SE.SoftwareEngineer;
import com.med.springboot.client.Client;
import com.med.springboot.repository.ClientRepository;
import com.med.springboot.repository.OrderRepository;
import com.med.springboot.repository.SoftwareEngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SoftwareEngineerRepository SERepository;

    public Order addOrder(
            OrderRequest request){
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        List<SoftwareEngineer> team = SERepository.findAllById(request.getEngineerIds());

        Order order = new Order();
        order.setClient(client);
        order.setTeam(team);
        order.setProjectName(request.getProjectName());
        order.setEstimatedDays(request.getEstimatedDays());
        order.setStartDate(request.getStartDate());
        order.setStatus("IN PROGRESS");
        order.setEndDate(request.getDeadline());

        return repository.save(order);
    }

    public List<Order> findAllOrders(){
        return repository.findAll();
    }

    public Order findOrderById(
            Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id){
        repository.deleteById(id);
    }

    public Order updateOrder(Long id, OrderRequest request) {

        // Find existing order
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        // Update basic fields
        order.setProjectName(request.getProjectName());
        order.setEstimatedDays(request.getEstimatedDays());
        order.setStartDate(request.getStartDate());
        order.setEndDate(request.getDeadline());

        // Update Client only if provided
        if (request.getClientId() != null) {
            Client client = clientRepository.findById(request.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            order.setClient(client);
        }

        // Update Team only if provided ← FIX IS HERE!
        if (request.getEngineerIds() != null && !request.getEngineerIds().isEmpty()) {
            List<SoftwareEngineer> team = SERepository.findAllById(request.getEngineerIds());
            order.setTeam(team);
        }
        // If engineerIds is null, we keep the existing team unchanged

        return repository.save(order);
    }
}

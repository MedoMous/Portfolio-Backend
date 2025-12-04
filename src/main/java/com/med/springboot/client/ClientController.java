package com.med.springboot.client;

import jakarta.websocket.server.PathParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController
{
    @Autowired
    private ClientService service;
    @GetMapping
    public List<Client> getAllClients() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(
            @PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Client createClient(
            @RequestBody Client client){
        return service.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(
            @PathVariable Long id , @RequestBody Client client){
        return service.update(id , client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(
            @PathVariable Long id){
        service.delete(id);
    }
}
